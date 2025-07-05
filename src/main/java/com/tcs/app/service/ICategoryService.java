package com.tcs.app.service;

import com.tcs.app.dto.CategoryDTO;

import java.io.IOException;
import java.util.List;

public interface ICategoryService {

   List<CategoryDTO> getAllCatgories() throws IOException;
}
