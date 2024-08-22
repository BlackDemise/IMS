package org.example.interviewmanagement.repositories;

import org.example.interviewmanagement.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RoleRepository extends JpaRepository<UserRole, Integer> {
    @Query("select ur.roleName " +
            "from UserRole ur " +
            "join User u on u.userRole.roleId = ur.roleId " +
            "where u.userFullName = :username")
    UserRole findUserRoleBy(@Param("username") String username);
}
