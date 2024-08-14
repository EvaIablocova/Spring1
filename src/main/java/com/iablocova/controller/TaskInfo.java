package com.iablocova.controller;

import com.iablocova.domain.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class TaskInfo {
    private String description;

    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
