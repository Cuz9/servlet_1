package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.MyConnection;
import model.Product;

public class ProductDAO {

	private Connection connection;
	private static final String SELECT_ALL_PRODUCT = "select * from product where enabel=0;";
	private static final String SELECT_BY_ID = "select * from product where id = ?;";
	private static final String INSERT_INTO = "insert into product(name, price, quantity, image, id_catergory) value (?,?,?,?,?);";
	private static final String UPDATE_BY_ID = "update product SET name = ?, price = ?, quantity = ?, image = ?, id_catergory = ? where id = ?;";
	private static final String DELETE_BY_ID = "update product SET enabel=1 where id = ?;";
	private static final String COUNT_ALL_PRODUCTS = "select count(*) from product where enabel=0;";
	private static final String SELECT_PRODUCTS_BY_PAGE = "select * from product where enabel=0 limit ? offset ?;";

	public ProductDAO() {
		connection = MyConnection.getConnection();
	}

	public List<Product> getProducts() {
		List<Product> products = new ArrayList<>();
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int idCatergory = rs.getInt("id_catergory");
				CategoryDAO catergoryDAO = new CategoryDAO();

				products.add(new Product(rs, catergoryDAO.findById(idCatergory)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public void create(Product product) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);) {
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getPrice());
			preparedStatement.setInt(3, product.getQuantity());
			preparedStatement.setString(4, product.getImage());
			preparedStatement.setInt(5, product.getCategory().getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(int id, Product product) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BY_ID);) {
			preparedStatement.setString(1, product.getName());
			preparedStatement.setDouble(2, product.getPrice());
			preparedStatement.setInt(3, product.getQuantity());
			preparedStatement.setString(4, product.getImage());
			preparedStatement.setInt(5, product.getCategory().getId());
			preparedStatement.setInt(6, product.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Product findById(int id) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);) {
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			CategoryDAO catergoryDAO = new CategoryDAO();
			while (rs.next()) {

				return new Product(rs, catergoryDAO.findById(rs.getInt("id_catergory")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delete(int id) {
		try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);) {

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getTotalProducts() {
		try (PreparedStatement preparedStatement = connection.prepareStatement(COUNT_ALL_PRODUCTS)) {
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Product> getProductsPaginated(int limit, int offset) {
		List<Product> products = new ArrayList<>();
		try (PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_BY_PAGE)) {
			preparedStatement.setInt(1, limit);
			preparedStatement.setInt(2, offset);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				int idCategory = rs.getInt("id_catergory");
				CategoryDAO categoryDAO = new CategoryDAO();
				products.add(new Product(rs, categoryDAO.findById(idCategory)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
}
