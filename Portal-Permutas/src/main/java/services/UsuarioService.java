package services;

import java.util.ArrayList;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.Actor;
import domain.ZonaDeseada;
import domain.PlazaPropia;
import domain.Usuario;
import forms.UsuarioForm;
import repositories.UsuarioRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class UsuarioService {

	// Managed repository-----------------------------------------------------

	@Autowired
	private UsuarioRepository usuarioRepository;

	// Supporting services----------------------------------------------------

	// @Autowired
	// private UserAccountService userAccountService;

	@Autowired
	private PlazaPropiaService plazaPropiaService;

	@Autowired
	private ActorService actorService;

	// Constructors-----------------------------------------------------------

	public UsuarioService() {
		super();
	}

	// Simple CRUD methods----------------------------------------------------

	// public Usuario create() {
	// Usuario result;
	// UserAccount userAccount;
	//
	// userAccount = createUserAccount();
	// result = new Usuario();
	//
	// result.setUserAccountId(userAccount.getId());
	//
	// return result;
	// }

	public Usuario findOne(String usuarioId) {
		Assert.notNull(usuarioId);

		Usuario result;

		result = usuarioRepository.findOne(usuarioId);

		return result;

	}

	public Collection<Usuario> findAll() {

		Collection<Usuario> result;

		result = usuarioRepository.findAll();

		return result;
	}

	public void save(Usuario usuario) {
		Assert.notNull(usuario);

		// UserAccount account =
		// userAccountService.findById(usuario.getUserAccountId());
		// Assert.notNull(account.getUsername());
		// Assert.notNull(account.getPassword());
		// Md5PasswordEncoder encoder;
		// encoder = new Md5PasswordEncoder();
		//
		// String password = account.getPassword();
		// password = encoder.encodePassword(password, null);
		// account.setPassword(password);

		usuarioRepository.save(usuario);
	}
	//
	// public void delete(Usuario usuario) {
	// Assert.notNull(usuario);
	//
	// usuarioRepository.delete(usuario);
	//
	// }

	// Other business methods-------------------------------------------------

	// public Usuario findByPrincipal() {
	// Usuario result;
	// UserAccount userAccount;
	//
	// userAccount = LoginService.getPrincipal();
	// result = findByUserAccount(userAccount);
	//
	// Assert.notNull(result);
	//
	// return result;
	// }
	//
	// public Usuario findByUserAccount(UserAccount userAccount) {
	// assert userAccount != null;
	//
	// Usuario result;
	//
	// result = usuarioRepository.findByUserAccountId(userAccount.getId());
	// assert result != null;
	//
	// return result;
	// }

	// Register methods-------------------------------------------------------

	// public UserAccount createUserAccount() {
	// UserAccount result;
	//
	// Authority authority;
	//
	// result = new UserAccount();
	//
	// authority = new Authority();
	// authority.setAuthority("USUARIO");
	//
	// result.addAuthority(authority);
	//
	// return result;
	// }

	// public Usuario reconstruct(UsuarioForm usuarioForm) {
	// Usuario result;
	//
	// // plazapropia
	// // plazaDeseada
	//
	// PlazaPropia plazaPropia;
	// Collection<String> plazasDeseadasId;
	// UserAccount userAccount;
	//
	// plazaPropia = plazaPropiaService.create();
	// plazasDeseadasId = new ArrayList<String>();
	//
	// result = create();
	// userAccount = userAccountService.findById(result.getUserAccountId());
	// userAccount.setPassword(usuarioForm.getPassword());
	// userAccount.setUsername(usuarioForm.getUsername());
	//
	// result.setEmail(usuarioForm.getEmail());
	// result.setNombre(usuarioForm.getNombre());
	// result.setTelefono(usuarioForm.getTelefono());
	// result.setApellidos(usuarioForm.getApellidos());
	//
	// plazaPropia.setCentro(usuarioForm.getCentro());
	// plazaPropia.setCiudad(usuarioForm.getCiudad());
	// plazaPropia.setDireccion(usuarioForm.getDireccion());
	// plazaPropia.setTitulo(usuarioForm.getTitulo());
	//
	// result.setPlazaPropiaId(plazaPropia.getId());
	// result.setPlazasDeseadasId(plazasDeseadasId);
	//
	// if (usuarioForm.getTermsAccepted() == false) {
	// throw new IllegalArgumentException("You must accept the terms and
	// condiditions");
	// }
	// if (!usuarioForm.getPassword().equals(usuarioForm.getSecondPassword())) {
	// throw new IllegalArgumentException("Passwords must match");
	// }
	// return result;
	// }
	//
	// public void modifyProfile(Usuario usuario) {
	// Assert.notNull(usuario);
	//
	// Actor result = actorService.findByPrincipal();
	// String name;
	// String surname;
	// String phone;
	// String email;
	//
	// phone = usuario.getTelefono();
	// surname = usuario.getApellidos();
	// name = usuario.getNombre();
	// email = usuario.getEmail();
	//
	// result.setTelefono(phone);
	// result.setApellidos(surname);
	// result.setNombre(name);
	// result.setEmail(email);
	// }

	// Temporal
	public Usuario reconstruct(UsuarioForm usuarioForm) {
		Usuario res;

		res = new Usuario();

		return res;
	}

	// Temporal
	public Usuario modificaUsuario(Usuario usuario) {
		Usuario res;

		res = new Usuario();

		return res;
	}

	public void validateUser(String userId) {
	}

	public void addPlazaDeseada(ZonaDeseada plazaDeseada) {

		// check principal
		// save plaza

	}

	public void deletePlazaDeseada(ZonaDeseada plazaDeseada) {

		// check principal
		// delete plaza del usuario
		// delete plaza

	}

}