package com.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class GenericDaoImpl <Entity extends Serializable, Identifier extends Serializable> implements GenericDao<Entity, Identifier> {
    private Class<Entity> entityClass;

    @PostConstruct
    public void init() {
        if(this.getTemplate() == null) {
            throw new RuntimeException("Hibernate Template is not set");
        }
        else {
            ParameterizedType genericSuperclass = (ParameterizedType)this.getClass().getGenericSuperclass();
            this.entityClass = (Class)genericSuperclass.getActualTypeArguments()[0];
        }
    }

    public abstract HibernateTemplate getTemplate();

    @Override
    public Entity save(Entity entity) {
        this.getTemplate().saveOrUpdate(entity);
        this.getTemplate().flush();
        return entity;
    }

    @Override
    public Entity getById(Identifier id) {
        return this.getTemplate().get(entityClass, id);
    }

    @Override
    public Entity remove(Identifier id) {
        Entity deleted = getById(id);
        this.getTemplate().delete(deleted);
        this.getTemplate().flush();
        return deleted;
    }
}
