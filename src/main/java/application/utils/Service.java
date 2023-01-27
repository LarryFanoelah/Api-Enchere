package application.utils;
import org.springframework.data.jpa.repository.JpaRepository;

import application.utils.annotation.IdTable;

import java.util.List;

public class Service<M,R extends JpaRepository<M,Integer>> {
    protected R repo;
    protected Class c;
    public Service(R repo){
        this.repo=repo;
    }
    public M saveOrUpdate(M model){
        return this.repo.save(model);
    }
    public void delete(M model){
        this.repo.delete(model);
    }
    public List<M> getAll(){
        return this.repo.findAll();
    }
    public M getById(Integer id) throws Exception{
        if(c.isAnnotationPresent(IdTable.class)){
            return (M) this.repo.findById(id);
        }
        throw new Exception("No id found");
    }
}
