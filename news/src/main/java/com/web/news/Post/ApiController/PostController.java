package com.web.news.Post.ApiController;



import com.web.news.Post.Domain.PostDto;
import com.web.news.Post.UseCase.IPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class PostController {
    
    @Autowired
    private IPostService postService;


    @GetMapping("/post")
    public String getAllPost(@RequestParam("page") int page, @RequestParam("limit") int limit, Model model) {
        PostOutput result = new PostOutput();
        result.setPage(page);
        Pageable pageable = PageRequest.of(page - 1 , limit);
        result.setPosts(postService.getAllPost(pageable));
        result.setTotalPages((int) Math.ceil((double) (postService.countPost()) / limit));
        model.addAttribute("posts", result.getPosts());
        return "Post/ListPost";
    }

    @GetMapping("/post/{id}")
    public String getPost(@ModelAttribute("post") PostDto post, @PathVariable("id") Long id, Model model) {
        post = postService.getPost(id);
        model.addAttribute("post", post);
        return "Post/DetailPost";
    }

    @GetMapping("/post/create")
    public String createPostForm(@ModelAttribute("post") PostDto post, Model model){
        model.addAttribute("post", post);
        return "Post/CreatePost";
    }

    @PostMapping("/post/create")
    public String createPost(PostDto post) {
        postService.save(post);
        return "redirect:/";
    }

    @GetMapping("/post/edit/{id}")
    public String editPostForm(PostDto post, @PathVariable("id") Long id, Model model){
        post = postService.getPost(id);
        model.addAttribute("post", post);
        return "Post/EditPost";
    }

    @PutMapping("/post/edit/{id}")
    public String updatePost(@ModelAttribute("post") PostDto post, @PathVariable("id") Long id) {
        post.setId(id);
        postService.update(post);
        return "redirect:/";
    }
    
    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable("id") Long id){
        postService.delete(id);
        return "redirect:/";
    }
}
