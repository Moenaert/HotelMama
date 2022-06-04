package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UsersEntity.class)
public abstract class UsersEntity_ {

	public static volatile SingularAttribute<UsersEntity, SupervisorEntity> supervisorBySupervisorId;
	public static volatile CollectionAttribute<UsersEntity, MtMJoinTableEntity> mtMJoinTablesById;
	public static volatile SingularAttribute<UsersEntity, String> name;
	public static volatile SingularAttribute<UsersEntity, Integer> id;
	public static volatile SingularAttribute<UsersEntity, Integer> supervisorId;

	public static final String SUPERVISOR_BY_SUPERVISOR_ID = "supervisorBySupervisorId";
	public static final String MT_MJOIN_TABLES_BY_ID = "mtMJoinTablesById";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String SUPERVISOR_ID = "supervisorId";

}

