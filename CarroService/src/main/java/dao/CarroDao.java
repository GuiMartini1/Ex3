package dao;

import model.Carro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CarroDao extends DAO {
	public CarroDao() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}

	public boolean insert(Carro insert) {
		boolean status = false;
		try {
			String sql = "INSERT INTO carro (codigo, modelo, ano, marca, quilometragem) "
					+ "VALUES ('" + insert.getCodigo() + "', "
					+ insert.getModelo() + ", " + insert.getAno() + "," + insert.getMarca() + ","+ insert.getQuilometragem();
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public Carro get(int codigo) {
		Carro carro = new Carro();

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM carro WHERE codigo=" + codigo;
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				carro = new Carro(rs.getInt("codigo"), rs.getString("modelo"), rs.getInt("ano"), rs.getString("marca"), rs.getInt("quilometragem"));
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carro;
	}

	public List<Carro> get() {
		return get("");
	}

	public List<Carro> getOrderByID() {
		return get("id");
	}

	public List<Carro> getOrderByDescricao() {
		return get("descricao");
	}

	public List<Carro> getOrderByPreco() {
		return get("preco");
	}

	private List<Carro> get(String orderBy) {
		List<Carro> carro = new ArrayList<Carro>();

		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM carro" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				Carro aux = new Carro(rs.getInt("codigo"), rs.getString("modelo"), rs.getInt("ano"), rs.getString("marca"), rs.getInt("quilometragem"));
				carro.add(aux);
			}
			st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return carro;
	}

	public boolean update(Carro carro) {
		boolean status = false;
		try {
			String sql = "UPDATE carro SET codigo = '" + carro.getCodigo() + "', "
					+ "modelo = " + carro.getModelo() + ", "
					+ "ano = " + carro.getAno() + ","
					+ "marca =" + carro.getMarca() + ", "
					+ "quiolometragem = " + carro.getQuilometragem() + " WHERE codigo = " + carro.getCodigo();
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public boolean delete(int codigo) {
		boolean status = false;
		try {
			Statement st = conexao.createStatement();
			st.executeUpdate("DELETE FROM carro WHERE codigo = " + codigo);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
}