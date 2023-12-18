package Services.Impl;

import java.util.List;
import DAO.ICartDAO;
import DAO.Impl.CartDAO;
import Models.Cart;
import Services.ICartSerive;

public class CartService implements ICartSerive {

	ICartDAO cartDAO = new CartDAO();

	@Override
	public List<Cart> findAll() {
		// TODO Auto-generated method stub
		return cartDAO.findAll();
	}

	@Override
	public void insert(Cart cart) {
		// TODO Auto-generated method stub
		cartDAO.insert(cart);
	}

	@Override
	public void update(Cart cart) {
		// TODO Auto-generated method stub
		cartDAO.update(cart);
	}

	@Override
	public void delete(int cart_id) {
		// TODO Auto-generated method stub
		cartDAO.delete(cart_id);
	}

	@Override
	public Cart findById(int cart_id) {
		// TODO Auto-generated method stub
		return cartDAO.findById(cart_id);
	}

	@Override
	public List<Cart> findByUserID(int user_id) {
		return cartDAO.findByUserID(user_id);
	}

	@Override
	public Cart findByUserIDAndProductId(int user_id, int product_id) {
		return cartDAO.findByUserIdAndProductID(user_id, product_id);
	}

}
