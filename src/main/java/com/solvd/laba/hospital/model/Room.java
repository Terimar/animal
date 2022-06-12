package com.solvd.laba.hospital.model;

public class Room {

    private Long id;
    private Integer number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public static RoomBuilder builder() {
        return new RoomBuilder(new Room());
    }

    public static class RoomBuilder {

        private final Room room;

        public RoomBuilder(Room room) {
            this.room = room;
        }

        public RoomBuilder id(Long id) {
            this.room.id = id;
            return this;
        }

        public RoomBuilder number(Integer number) {
            this.room.number = number;
            return this;
        }

        public Room build() {
            return room;
        }
    }
}
