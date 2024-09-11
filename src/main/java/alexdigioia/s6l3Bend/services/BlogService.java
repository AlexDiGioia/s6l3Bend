package alexdigioia.s6l3Bend.services;

import alexdigioia.s6l3Bend.entities.Blog;
import alexdigioia.s6l3Bend.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BlogService {

    private final List<Blog> blogList = new ArrayList<>();

    public List<Blog> findAll() {
        return this.blogList;
    }

    public Blog saveBlog(Blog body) {
        Random random = new Random();
        body.setId(random.nextInt(1, 10000));
        this.blogList.add(body);
        return body;
    }

    public Blog findById(int id) {
        Blog found = null;
        for (Blog blog : this.blogList) {
            if (blog.getId() == id) {
                found = blog;
            }
        }
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public Blog findByIdAndUpdate(int id, Blog updatedBlog) {
        Blog found = null;
        for (Blog blog : this.blogList) {
            if (blog.getId() == id) {
                found = blog;
                found.setCategoria(updatedBlog.getCategoria());
                found.setTitolo(updatedBlog.getTitolo());
                found.setCover(updatedBlog.getCover());
                found.setTempoDiLettura(updatedBlog.getTempoDiLettura());
            }
        }
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public void findByIdAndDelete(int id) {
        Blog found = null;
        for (Blog blog : this.blogList) {
            if (blog.getId() == id) {
                found = blog;
            }
        }
        if (found == null) throw new NotFoundException(id);
        this.blogList.remove(found);
    }
}


