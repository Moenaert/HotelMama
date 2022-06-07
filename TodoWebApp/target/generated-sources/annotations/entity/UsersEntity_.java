package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UsersEntity.class)
public abstract class UsersEntity_ {

	public static volatile SingularAttribute<UsersEntity, Integer> usersId;
	public static volatile SingularAttribute<UsersEntity, String> username;

	public static final String USERS_ID = "usersId";
	public static final String USERNAME = "username";

}

