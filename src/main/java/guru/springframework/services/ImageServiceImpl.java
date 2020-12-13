package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;

@Slf4j
@AllArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {

    private final RecipeRepository recipeRepository;

    @Override
    @Transactional
    public void saveImageFile(Long recipeId, MultipartFile file) {
        try {
            Recipe recipe = recipeRepository.findById(recipeId).get();

            Byte[] bytes = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b: file.getBytes()) {
                bytes[i++] = b;
            }

            recipe.setImage(bytes);

            recipeRepository.save(recipe);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
