package Services;

import java.util.List;

import Models.Category;

public interface ICategoryService {
	List<Category> findAll();

	void insert(Category category);

	void update(Category category);

	void delete(int category_id);

	Category findById(int category_id);

	int countProduct(int category_id);
}
