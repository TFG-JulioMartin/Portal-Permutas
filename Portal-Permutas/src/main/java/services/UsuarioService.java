package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import domain.PlazaPropia;
import domain.ZonaDeseada;
import forms.UsuarioForm;
import security.UserAccount;
import security.UserAccountRepository;

@Service
@Transactional
public class UsuarioService {

	// Managed repository-----------------------------------------------------

	@Autowired
	private UserAccountRepository userAccountRepository;

	// Supporting services----------------------------------------------------

	@Autowired
	private PlazaPropiaService plazaPropiaService;

	// Constructors-----------------------------------------------------------

	public UsuarioService() {
		super();
	}

	// Simple CRUD methods----------------------------------------------------

	public void create(UserAccount userAccount) {

		userAccount.setAccountNonExpired(true);
		userAccount.setAccountNonLocked(true);
		userAccount.setCredentialsNonExpired(true);
		userAccount.setEnabled(true);
		userAccount.addRole("ROLE_USER");

		save(userAccount);
	}

	public UserAccount findOne(String usuarioId) {
		Assert.notNull(usuarioId);

		UserAccount result;

		result = userAccountRepository.findOne(usuarioId);

		return result;

	}

	public Collection<UserAccount> findAll() {

		Collection<UserAccount> result;

		result = userAccountRepository.findAll();

		return result;
	}

	public void save(UserAccount userAccount) {
		Assert.notNull(userAccount);

		Assert.notNull(userAccount.getUsername());
		Assert.notNull(userAccount.getPassword());
		Md5PasswordEncoder encoder;
		encoder = new Md5PasswordEncoder();

		String password = userAccount.getPassword();
		password = encoder.encodePassword(password, null);
		userAccount.setPassword(password);

		userAccountRepository.save(userAccount);
	}

	public void delete(UserAccount usuario) {
		Assert.notNull(usuario);

		userAccountRepository.delete(usuario);

	}

	// Other business methods-------------------------------------------------

	public void reconstruct(UsuarioForm usuarioForm) {
		UserAccount userAccount;
		PlazaPropia plazaPropia;

		userAccount = new UserAccount();
		 plazaPropia = new PlazaPropia();

		userAccount.setApellidos(usuarioForm.getApellidos());
		userAccount.setEmail(usuarioForm.getEmail());
		userAccount.setNombre(usuarioForm.getNombre());
		userAccount.setTelefono(usuarioForm.getTelefono());
		userAccount.setUsername(usuarioForm.getUsername());
		userAccount.setPassword(usuarioForm.getPassword());


		create(userAccount);

		plazaPropia.setCentro(usuarioForm.getCentro());
		plazaPropia.setCiudad(usuarioForm.getCiudad());
		plazaPropia.setDireccion(usuarioForm.getDireccion());
		plazaPropia.setTitulo(usuarioForm.getTitulo());
		plazaPropia.setUsuarioId(userAccount.getId());

		plazaPropiaService.save(plazaPropia);

	}

	public void modificaUserAccount(UserAccount usuario) {
		
		// Cambiar a buscar la cuenta del principal.
		UserAccount userAccount = findOne("5895b95e61e67638e2cb19c2");
		
		userAccount.setApellidos(usuario.getApellidos());
		userAccount.setEmail(usuario.getEmail());
		userAccount.setNombre(usuario.getNombre());
		userAccount.setTelefono(usuario.getTelefono());
		
		save(userAccount);
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