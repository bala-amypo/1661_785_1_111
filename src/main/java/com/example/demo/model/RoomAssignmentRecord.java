package com.example.demo.model;

public class RoomAssignmentRecord {

    private Long id;
    private Long studentAId;
    private Long studentBId;
    private String roomNumber;
    private Status status;

    public enum Status { ACTIVE, COMPLETED, CANCELLED }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentAId() { return studentAId; }
    public void setStudentAId(Long studentAId) { this.studentAId = studentAId; }

    public Long getStudentBId() { return studentBId; }
    public void setStudentBId(Long studentBId) { this.studentBId = studentBId; }

    public String getRoomNumber() { return roomNumber; }
    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
