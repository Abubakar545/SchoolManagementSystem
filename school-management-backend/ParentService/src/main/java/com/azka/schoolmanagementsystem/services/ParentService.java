package com.azka.schoolmanagementsystem.services;


import com.azka.schoolmanagementsystem.entities.Parent;

import java.util.List;
import java.util.Optional;

public interface ParentService {

    Parent saveParent(Parent parent);

    List<Parent> getAllParents();

    Parent updateParent(Long id, Parent parent);

    void deleteParent(Long id);

    Optional<Parent> getParentById(Long id);
}