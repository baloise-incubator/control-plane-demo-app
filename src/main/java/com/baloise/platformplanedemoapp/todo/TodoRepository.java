package com.baloise.platformplanedemoapp.todo;

import org.springframework.data.repository.CrudRepository;

interface TodoRepository extends CrudRepository<Todo, Long> {

}
