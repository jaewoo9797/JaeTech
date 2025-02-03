package com.jaetech.article.db;

import static org.junit.jupiter.api.Assertions.*;

import com.jaetech.article.entity.Article;
import com.jaetech.category.db.CategoryRepository;
import com.jaetech.category.entity.Category;
import com.jaetech.config.JpaAuditingConfiguration;
import com.jaetech.user.db.UserRepository;
import com.jaetech.user.entity.User;
import com.jaetech.user.entity.enums.UserRole;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@DataJpaTest
@Import(value = {JpaAuditingConfiguration.class})
class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository CategoryRepository;

    private static User createUser() {
        return new User("test", "test@mail.com", UserRole.GUEST);
    }

    private static Article createArticle(User user, Category category) {
        return new Article("testTitle", "testContent", user, category);
    }

    private static Category createCategory() {
        return new Category("testcategory", "this is test category");
    }

    @Test
    void 게시글_저장() {
        //given
        User user = userRepository.save(createUser());
        Category category = CategoryRepository.save(createCategory());
        Article article = createArticle(user, category);
        // when
        Article savedArticle = articleRepository.save(article);
        em.flush();
        em.clear();
        // Article foundArticle = articleRepository.findById(savedArticle.getId()).get();
        // then
        User foundUser = userRepository.findById(user.getId()).get();
        System.out.println(foundUser.getArticles().get(0).getId());
    }
}