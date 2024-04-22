package br.edu.bdEmarcado.respositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.bdEmarcado.entidade.Usuario;

//esse código é um pouquinho mais complexo, mas vamos la...


public class UsuarioRepositorio {
	
	//Cria um objeto do tipo Connection
	private Connection conn;
	
	//Configura a conexão com o banco de dados h2
	public UsuarioRepositorio() throws SQLException {
		conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
	}
	
	//crio uma funçaõ do chamada "listarUsuarios", que armazena usuarios em um arrayList
	public List<Usuario> listarUsuarios() {
		//declaro o arrayList
		List<Usuario> lstUsuarios = new ArrayList<Usuario>();
		
		/*Essa é a querry (comando) sql que será executado. no caso, ele vai consultar 
		 no banco os usuarios que tem esses atributos ai*/
		String sql = "select id, nome, email, senha from usuario";
		
		/*aqui a gente cria um try e catch (se nao usar isso, o codigo 
		nao roda, por que ele precisa que o erro seja tratado)*/
		try {
			//define o prepared Statement como o comando sql que a gente criou
			PreparedStatement pst = conn.prepareStatement(sql);
			
			//executa o prepared Statement que fez ai em cima
			ResultSet resultSet = pst.executeQuery();
			
			/*nisso aqui basicamente ele vai checar se tem mais coisa pra verificar no resultSet
			  e enquanto tiver ele vai rodar esse comandin ai. Os comandinho no caso é pra instanciar
			  um usuario e definir os atributos dele. dps disso, esse usuairo é 
			  adicionado ao arraylist la de cima*/
			while (resultSet.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultSet.getInt("id"));
				usuario.setEmail(resultSet.getString("email"));
				usuario.setSenha(resultSet.getString("senha"));
				usuario.setNome(resultSet.getString("nome"));
			
				lstUsuarios.add(usuario);
			}
		}catch (Exception e) {
			//isso aqui é so pra tratar o erro
			e.printStackTrace();
		}
		
		//retorna a lista de usuarios
		return lstUsuarios;
	}
}
