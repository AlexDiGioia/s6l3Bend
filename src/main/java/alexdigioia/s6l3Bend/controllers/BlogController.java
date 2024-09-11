package alexdigioia.s6l3Bend.controllers;

import alexdigioia.s6l3Bend.entities.Blog;
import alexdigioia.s6l3Bend.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    //Get http://localhost:3001/blogs
    @GetMapping
    private List<Blog> getAllBlogs() {
        return blogService.findAll();
    }

    //Get http://localhost:3001/blogs/{blogId}
    //Get http://localhost:3001/blogs/123
    @GetMapping("/{blogId}")
    private Blog getBlogById(@PathVariable int blogId) {
        return blogService.findById(blogId);
    }

    //Post http://localhost:3001/blogs/  +BODY
    @PostMapping
    private Blog createBlog(@RequestBody Blog body) {
        return blogService.saveBlog(body);
    }

    //Put http://localhost:3001/blogs/{blogId}  +BODY
    //Put http://localhost:3001/blogs/123
    @PutMapping("/{blogId}")
    private Blog findBlogByIdAndUpdate(@PathVariable int blogId, @RequestBody Blog body) {
        return blogService.findByIdAndUpdate(blogId, body);
    }

    //Delete http://localhost:3001/blogs/{blogId}
    //Delete http://localhost:3001/blogs/123
    @DeleteMapping("/{blogId}")
    private void findBlogByIdAndDelete(@PathVariable int blogId) {
        blogService.findByIdAndDelete(blogId);
    }

}
