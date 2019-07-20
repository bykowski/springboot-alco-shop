package pl.bykowski.springbootgui;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlcoholRepo extends JpaRepository<Alcohol, Long> {
}
