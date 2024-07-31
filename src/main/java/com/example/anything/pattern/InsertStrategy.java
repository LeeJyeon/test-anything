package com.example.anything.pattern;

public interface InsertStrategy<Entity, ValidationCode> {
    ValidationCode insert(Entity entity);
}
