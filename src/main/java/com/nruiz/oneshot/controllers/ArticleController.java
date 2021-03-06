 package com.nruiz.oneshot.controllers;

 import com.nruiz.oneshot.models.Article;
 import com.nruiz.oneshot.models.Elem;
 import com.nruiz.oneshot.services.ArticleService;
 import org.springframework.http.HttpStatus;
 import org.springframework.http.ResponseEntity;
 import org.springframework.web.bind.annotation.*;

 import java.util.List;

/**
 * Created by Nicolas on 28/10/2017.
 */
@RestController
@RequestMapping("/article")
public class ArticleController {


    private ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public ResponseEntity<List<Article>> getArticles(){
        return new ResponseEntity<>(this.articleService.getArticles(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method= RequestMethod.GET)
    public ResponseEntity<Article> getArticleById(@PathVariable long id){
        return new ResponseEntity<>(this.articleService.getArticleById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/ids", method= RequestMethod.POST, produces="application/json", consumes="application/json")
    public ResponseEntity<List<Article>> getArticlesByIds(@RequestBody List<Elem> elems){
        return new ResponseEntity<>(this.articleService.getArticlesByElems(elems), HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method= RequestMethod.POST, produces="application/json", consumes="application/json")
    public ResponseEntity<Article> saveArticle(@RequestBody Article article){
        return new ResponseEntity<>(this.articleService.saveArticle(article), HttpStatus.CREATED);
    }
}
