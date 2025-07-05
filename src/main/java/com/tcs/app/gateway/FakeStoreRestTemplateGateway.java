package com.tcs.app.gateway;

import com.tcs.app.dto.CategoryDTO;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@Primary
public class FakeStoreRestTemplateGateway implements ICategoryGateway {

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return List.of();
    }
}
