package com.dao;

public interface GenericDao<Entity, Identifier> {
    Entity save(Entity var);
    Entity getById(Identifier id);
    Entity remove(Identifier id);
}
