package com.configLoader;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfigEntryRepository extends JpaRepository<ConfigEntry, String> {
}
