package org.sid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING,length=3)
@DiscriminatorValue("usr")

public class User implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private String adresse;
	@Column(unique=true)
	private String username;
	private String password;
	private String tel;
	private boolean actived;
	private String img;
	
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	private Collection<Abonnement> abs;
	@ManyToMany
	private Collection<Matiere> matieres;
	@OneToMany(mappedBy="user",fetch=FetchType.LAZY)
	private Collection<Commentaire> commentaires;
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<AppRole> roles= new ArrayList<AppRole>();
	public User() {
		super();
	}
	public User( String nom, String prenom, String email,
			String adresse, String username, String tel
			) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.username = username;
		this.tel = tel;
		
	}


	





	public User(int id, String nom, String prenom, String email,
			String adresse, String username, String password, String tel,
			boolean actived,String img) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
		this.username = username;
		this.password = password;
		this.tel = tel;
		this.actived = actived;
		this.img=img;
	}








	public Collection<Abonnement> getAbs() {
		return abs;
	}

	public void setAbs(Collection<Abonnement> abs) {
		this.abs = abs;
	}

	public Collection<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(Collection<Matiere> matieres) {
		this.matieres = matieres;
	}

	public Collection<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(Collection<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}




	public boolean isActived() {
		return actived;
	}








	public void setActived(boolean actived) {
		this.actived = actived;
	}








	public Collection<AppRole> getRoles() {
		return roles;
	}








	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}








	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}
	public String getImg() {
		return img;
	}




	public void setImg(String img) {
		this.img = img;
	}

	
	
	





}
