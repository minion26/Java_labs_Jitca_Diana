package main.java.com.example;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "genre", schema = "public", catalog = "albums")
@NamedQueries({
        @NamedQuery(name = "Genre.findAll", query = "select e from GenreEntity e order by e.name"),
        @NamedQuery(name = "Genre.findByName", query = "select e from GenreEntity e where e.name = :name"),
        @NamedQuery(name = "Genre.findById", query = "select e from GenreEntity e where e.id = :id")
})
public class GenreEntity implements Serializable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GenreEntity that = (GenreEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GenreEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
