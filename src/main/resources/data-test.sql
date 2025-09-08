-- Active: 1756990809230@@127.0.0.1@5432@mabase@dbo
-- Données de test pour l'application Fiche
-- Script à exécuter pour remplir la base de données avec des données fictives

-- Suppression des données existantes (optionnel)
-- DELETE FROM fiche_categorie;
-- DELETE FROM commentaires;
-- DELETE FROM fiches;
-- DELETE FROM categories;
-- DELETE FROM users;

-- Insertion des catégories
INSERT INTO categories (nom) VALUES
('Informatique'),
('Mathématiques'),
('Sciences'),
('Littérature'),
('Histoire'),
('Philosophie'),
('Langues'),
('Art'),
('Musique'),
('Sport');

-- Insertion des utilisateurs
INSERT INTO users (username, password, grants) VALUES
('admin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE4d7jbcK4x5Jw8/6', '{"ROLE_SUPER_ADMIN"}'),
('moderateur', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE4d7jbcK4x5Jw8/6', '{"ROLE_ADMIN"}'),
('pierre.martin', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE4d7jbcK4x5Jw8/6', '{"ROLE_USER"}'),
('marie.dupont', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE4d7jbcK4x5Jw8/6', '{"ROLE_USER"}'),
('jean.durand', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE4d7jbcK4x5Jw8/6', '{"ROLE_USER"}'),
('sophie.bernard', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE4d7jbcK4x5Jw8/6', '{"ROLE_USER"}'),
('luc.moreau', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE4d7jbcK4x5Jw8/6', '{"ROLE_USER"}'),
('alice.robert', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE4d7jbcK4x5Jw8/6', '{"ROLE_USER"}'),
('thomas.petit', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE4d7jbcK4x5Jw8/6', '{"ROLE_USER"}'),
('emma.richard', '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE4d7jbcK4x5Jw8/6', '{"ROLE_USER"}');

-- Insertion des fiches
INSERT INTO fiches (titre, texte_fiche, date, auteur_fiche_id) VALUES
('Introduction à Spring Boot', 'Spring Boot est un framework Java qui simplifie le développement d''applications Spring. Il fournit une configuration automatique et des starters pour démarrer rapidement...', '2024-01-15 10:30:00', 3),
('Les bases de l''algorithme de tri rapide', 'Le tri rapide (QuickSort) est un algorithme de tri très efficace basé sur le principe "diviser pour régner". Il fonctionne en choisissant un élément pivot...', '2024-01-20 14:45:00', 4),
('Introduction à la mécanique quantique', 'La mécanique quantique est une théorie physique qui décrit le comportement de la matière et de l''énergie à l''échelle atomique et subatomique...', '2024-01-25 09:15:00', 5),
('L''existentialisme selon Sartre', 'Jean-Paul Sartre développe dans ses œuvres une philosophie existentialiste où "l''existence précède l''essence". Cette conception révolutionnaire...', '2024-02-01 16:20:00', 6),
('Guide de démarrage PostgreSQL', 'PostgreSQL est un système de gestion de base de données relationnelle-objet très puissant. Ce guide vous aidera à installer et configurer PostgreSQL...', '2024-02-05 11:10:00', 3),
('Les révolutions françaises', 'La France a connu plusieurs révolutions majeures qui ont transformé sa structure politique et sociale. De 1789 à 1848, ces événements...', '2024-02-10 13:25:00', 7),
('Apprendre le JavaScript moderne', 'JavaScript ES6+ a introduit de nombreuses fonctionnalités qui ont révolutionné le développement web. Les arrow functions, les modules, async/await...', '2024-02-15 08:40:00', 8),
('Techniques de peinture à l''huile', 'La peinture à l''huile offre une richesse de couleurs et une capacité de mélange exceptionnelle. Les techniques de glacis, d''empâtement...', '2024-02-20 15:55:00', 9),
('Théorie musicale : les gammes', 'Comprendre les gammes est fondamental en musique. La gamme majeure, construite selon un pattern spécifique d''intervalles...', '2024-02-25 10:05:00', 10),
('Nutrition et performance sportive', 'L''alimentation joue un rôle crucial dans les performances sportives. Les macronutriments (glucides, protéines, lipides) doivent être équilibrés...', '2024-03-01 12:30:00', 4);

-- Insertion des associations fiche-catégorie
INSERT INTO fiche_categorie (fiche_id, cetegorie_id) VALUES
-- Spring Boot (Informatique)
(1, 1),
-- Tri rapide (Informatique, Mathématiques)
(2, 1), (2, 2),
-- Mécanique quantique (Sciences)
(3, 3),
-- Existentialisme (Philosophie)
(4, 6),
-- PostgreSQL (Informatique)
(5, 1),
-- Révolutions françaises (Histoire)
(6, 5),
-- JavaScript (Informatique)
(7, 1),
-- Peinture à l'huile (Art)
(8, 8),
-- Théorie musicale (Musique)
(9, 9),
-- Nutrition sportive (Sport, Sciences)
(10, 10), (10, 3);

-- Insertion des commentaires
INSERT INTO commentaires (texte_commentaire, date, user_id, fiche_id) VALUES
('Excellente introduction ! Très clair et bien structuré.', '2024-01-16 09:45:00', 4, 1),
('Merci pour ce tutoriel, ça m''a beaucoup aidé pour démarrer avec Spring Boot.', '2024-01-17 14:20:00', 5, 1),
('Pourriez-vous ajouter des exemples de code plus avancés ?', '2024-01-18 11:30:00', 6, 1),

('L''explication de la complexité temporelle est très bien faite.', '2024-01-21 16:15:00', 3, 2),
('J''aurais aimé voir une comparaison avec d''autres algorithmes de tri.', '2024-01-22 10:25:00', 7, 2),

('Sujet complexe mais bien vulgarisé. Bravo !', '2024-01-26 13:40:00', 8, 3),
('Les formules mathématiques sont un peu difficiles à suivre.', '2024-01-27 09:20:00', 9, 3),
('Excellent pour une première approche de la physique quantique.', '2024-01-28 15:10:00', 10, 3),

('Sartre expliqué de manière accessible, merci !', '2024-02-02 11:45:00', 3, 4),
('Cette fiche résume bien les concepts clés de l''existentialisme.', '2024-02-03 14:35:00', 4, 4),

('Très utile pour débuter avec PostgreSQL. Les commandes sont bien détaillées.', '2024-02-06 08:50:00', 5, 5),
('Manque peut-être quelques exemples de requêtes plus complexes.', '2024-02-07 16:40:00', 6, 5),

('Récit captivant des événements révolutionnaires.', '2024-02-11 12:15:00', 7, 6),
('Les dates et les personnages sont bien situés dans leur contexte.', '2024-02-12 09:30:00', 8, 6),

('JavaScript moderne enfin expliqué clairement !', '2024-02-16 13:20:00', 9, 7),
('Les exemples de code sont très pratiques.', '2024-02-17 10:45:00', 10, 7),
('Pourriez-vous ajouter une section sur les Promises ?', '2024-02-18 15:25:00', 3, 7),

('En tant qu''amateur de peinture, je trouve ces conseils très précieux.', '2024-02-21 11:10:00', 4, 8),
('Les techniques décrites sont bien expliquées.', '2024-02-22 14:55:00', 5, 8),

('Parfait pour comprendre les bases de la théorie musicale.', '2024-02-26 09:35:00', 6, 9),
('Les exemples audio seraient un plus.', '2024-02-27 16:20:00', 7, 9),

('Très instructif pour optimiser ses performances sportives.', '2024-03-02 12:40:00', 8, 10),
('Les conseils nutritionnels sont pratiques et applicables.', '2024-03-03 10:15:00', 9, 10),
('Merci pour ces informations sur l''hydratation pendant l''effort.', '2024-03-04 13:50:00', 10, 10);
