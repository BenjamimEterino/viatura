
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAOViatura {
	
	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://localhost:8086/viaturasajax";

	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	private Connection conectar() {
		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			System.out.println("contectado");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Teste conexao.
	 */
	public void testeConexao() {
		try {
			Connection con = conectar();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Inserir contacto.
	 *
	 * @param contacto the contacto
	 */
	public void inserirContacto(Viatura contacto) {
		String create = "insert into viatura (nome, marca, fabrico, tip)" + "values(?,?,?,?)";

		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(create);

			pst.setString(1, contacto.getNome());
			pst.setString(2, contacto.getMarca());
			pst.setDate(3, contacto.getFabrico());
			pst.setLong(3, contacto.getTipo());

			pst.executeUpdate();

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Listar.
	 *
	 * @return the array list
	 */
	public ArrayList<Viatura> listar() {
		ArrayList<Viatura> viatura = new ArrayList<>();
		String read = "select cod, nome, marca, fabrico, descricao from viatura t1 inner join tipo t2 on t1.tip = t2.codigo";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				Long id_viatura = rs.getLong(1);
				String nome = rs.getString(2);
				String marca = rs.getString(3);
				Date fabrico  = rs.getDate(4);
				String tipoDesc = rs.getString(5);

				viatura.add(new Viatura(id_viatura, nome, marca, fabrico, tipoDesc));
			}
			con.close();
			return viatura;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	/**
	 * Selecionar contacto.
	 *
	 * @param viatura the contacto
	 */
	public void selecionarContacto(Viatura viatura) {

		String select = "select * from viatura where cod = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(select);
			pst.setLong(1, viatura.getCod());
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				viatura.setCod(rs.getLong(1));
				viatura.setNome(rs.getString(2));
				viatura.setMarca(rs.getString(3));
				viatura.setFabrico(rs.getDate(4));
				viatura.setTipo(rs.getLong(5));

			}
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	/**
	 * Actualizar contacto.
	 *
	 * @param viatura the contacto
	 */
	public void actualizarContacto(Viatura viatura) {
		String update = " update viatura set nome=  ?, marca = ?, fabrico = ?, tip =? where cod = ?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);

			pst.setString(1, viatura.getNome());
			pst.setString(2, viatura.getMarca());
			pst.setDate(3, viatura.getFabrico());
			pst.setLong(4, viatura.getTipo());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Deletar contacto.
	 *
	 * @param viatura the contacto
	 */
	public void deletarContacto(Viatura viatura) {
		String delete = "delete from viatura where cod=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			
			pst.setLong(1, viatura.getCod());
			
			pst.executeUpdate();
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

