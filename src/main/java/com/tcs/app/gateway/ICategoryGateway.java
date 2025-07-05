package com.tcs.app.gateway;

import com.tcs.app.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryGateway {

   List<CategoryDTO> getAllCategories() throws IOException;
}
