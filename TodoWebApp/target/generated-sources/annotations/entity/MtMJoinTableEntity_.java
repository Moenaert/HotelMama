package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MtMJoinTableEntity.class)
public abstract class MtMJoinTableEntity_ {

	public static volatile SingularAttribute<MtMJoinTableEntity, Integer> joinId;
	public static volatile SingularAttribute<MtMJoinTableEntity, Integer> userId;
	public static volatile SingularAttribute<MtMJoinTableEntity, Integer> toDoId;

	public static final String JOIN_ID = "joinId";
	public static final String USER_ID = "userId";
	public static final String TO_DO_ID = "toDoId";

}

