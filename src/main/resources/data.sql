

-- Insert into Board
--INSERT INTO boards (id)
--VALUES ('b3b8f4e8-6b5f-11ec-90d6-0242ac120003');
--INSERT INTO boards (id)
--VALUES ('a1b2c3d4-6b5f-11ec-90d6-0242ac120004');



-- Insert into Game
INSERT INTO games (id, gamestate, current_player_id)
VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', 'NOT_STARTED', NULL);
INSERT INTO games (id, gamestate, current_player_id)
VALUES ('a2b3c4d5-6b5f-11ec-90d6-0242ac120004', 'STARTED', NULL);

INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120003', 'Bezem');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120004', 'Zak Goud');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120005', 'Schip');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120006', 'Sleutel');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120007', 'Kroon');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120008', 'Drankje');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120009', 'Geest');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120010', 'Schijf (Amulet)');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120011', 'Ring');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120012', 'Buidel');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120013', 'Kaars');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120014', 'Helm');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120015', 'Zwaard');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120016', 'Schatkist');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120017', 'Uil');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120018', 'Spin');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120019', 'Vleermuis');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120020', 'Rat');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120021', 'Kabouter');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120022', 'Boek');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120023', 'Ketting');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120024', 'Vogel');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120025', 'koe');
INSERT INTO treasures (id, item)
VALUES ('d5a7b8b0-6b5f-11ec-90d6-0242ac120026', 'kip');

INSERT INTO cards (id, treasure_id) VALUES ('e8a1a2c6-1b6e-4b70-b5b8-d0987ec5b9d4', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120003'); -- Bezem
INSERT INTO cards (id, treasure_id) VALUES ('dc383a68-7e09-4dc6-96ec-f79d5c673b4d', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120004'); -- Zak Goud
INSERT INTO cards (id, treasure_id) VALUES ('0f71a85b-e042-4c2a-9a9a-bd9f9c1e6cf5', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120005'); -- Schip
INSERT INTO cards (id, treasure_id) VALUES ('b9e3bfa6-365c-4a79-905a-e029eb22f3d7', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120006'); -- Sleutel
INSERT INTO cards (id, treasure_id) VALUES ('4a3f8e09-d4bc-4e80-9a12-ff827fa6260b', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120007'); -- Kroon
INSERT INTO cards (id, treasure_id) VALUES ('fa7f234c-41f6-4c99-8970-e3783fc79a42', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120008'); -- Drankje
INSERT INTO cards (id, treasure_id) VALUES ('d98d1b70-2b0e-4c27-9f68-3b763ac9f9d6', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120009'); -- Geest
INSERT INTO cards (id, treasure_id) VALUES ('7fbd15d7-dbd9-4340-b57a-bb6dc74d5b6f', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120010'); -- Schijf (Amulet)
INSERT INTO cards (id, treasure_id) VALUES ('a04d83d1-705f-48ff-9fc4-b91e6db0b23d', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120011'); -- Ring
INSERT INTO cards (id, treasure_id) VALUES ('f3e826c7-409a-48ed-b68c-973cc71a20f4', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120012'); -- Buidel
INSERT INTO cards (id, treasure_id) VALUES ('2a78cc3d-1f51-4423-9b40-23e0a5d515c6', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120013'); -- Kaars
INSERT INTO cards (id, treasure_id) VALUES ('9d6d8c68-82b2-4d65-9d29-9143d38d7493', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120014'); -- Helm
INSERT INTO cards (id, treasure_id) VALUES ('eeaeb5d0-7a41-4a61-b3f4-f3c5b0c8305b', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120015'); -- Zwaard
INSERT INTO cards (id, treasure_id) VALUES ('c7313f3c-6e43-4c0c-8b72-829e821ae8e0', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120016'); -- Schatkist
INSERT INTO cards (id, treasure_id) VALUES ('46b59e66-4288-43dc-931c-3a5b72f9f5c8', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120017'); -- Uil
INSERT INTO cards (id, treasure_id) VALUES ('cd27a6b5-8b5d-45ea-8149-09e1e7323c3d', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120018'); -- Spin
INSERT INTO cards (id, treasure_id) VALUES ('b9e98c4f-c3a2-4094-8962-0a897cf760d1', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120019'); -- Vleermuis
INSERT INTO cards (id, treasure_id) VALUES ('c1b2d786-6220-4db6-a2a7-061f4b74dbd8', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120020'); -- Rat
INSERT INTO cards (id, treasure_id) VALUES ('7c71b9f5-44cb-4b62-8ff1-bc4c39c83c0a', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120021'); -- Kabouter
INSERT INTO cards (id, treasure_id) VALUES ('49e5d5b0-1f0d-4d80-a912-d7ecb8cbca8e', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120022'); -- Boek
INSERT INTO cards (id, treasure_id) VALUES ('c6e477f4-f11e-43d3-b34c-4de7c76b7806', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120023'); -- Ketting
INSERT INTO cards (id, treasure_id) VALUES ('9b0692e1-477d-46f2-a44d-3a9b4b7b1d7d', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120024'); -- Vogel
INSERT INTO cards (id, treasure_id) VALUES ('4685b2d3-4a8a-4d2c-9f78-1e5a77b4fcf6', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120025'); -- Koe
INSERT INTO cards (id, treasure_id) VALUES ('3d98a4f1-4c62-4d58-94f7-cf85acb1345c', 'd5a7b8b0-6b5f-11ec-90d6-0242ac120026'); -- Kip

INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', 'e8a1a2c6-1b6e-4b70-b5b8-d0987ec5b9d4'); -- Bezem
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', 'dc383a68-7e09-4dc6-96ec-f79d5c673b4d'); -- Zak Goud
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', '0f71a85b-e042-4c2a-9a9a-bd9f9c1e6cf5'); -- Schip
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', 'b9e3bfa6-365c-4a79-905a-e029eb22f3d7'); -- Sleutel
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', '4a3f8e09-d4bc-4e80-9a12-ff827fa6260b'); -- Kroon
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', 'fa7f234c-41f6-4c99-8970-e3783fc79a42'); -- Drankje
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', 'd98d1b70-2b0e-4c27-9f68-3b763ac9f9d6'); -- Geest
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', '7fbd15d7-dbd9-4340-b57a-bb6dc74d5b6f'); -- Schijf (Amulet)
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', 'a04d83d1-705f-48ff-9fc4-b91e6db0b23d'); -- Ring
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', 'f3e826c7-409a-48ed-b68c-973cc71a20f4'); -- Buidel
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', '2a78cc3d-1f51-4423-9b40-23e0a5d515c6'); -- Kaars
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', '9d6d8c68-82b2-4d65-9d29-9143d38d7493'); -- Helm
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', 'eeaeb5d0-7a41-4a61-b3f4-f3c5b0c8305b'); -- Zwaard
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', 'c7313f3c-6e43-4c0c-8b72-829e821ae8e0'); -- Schatkist
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', '46b59e66-4288-43dc-931c-3a5b72f9f5c8'); -- Uil
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', 'cd27a6b5-8b5d-45ea-8149-09e1e7323c3d'); -- Spin
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', 'b9e98c4f-c3a2-4094-8962-0a897cf760d1'); -- Vleermuis
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', 'c1b2d786-6220-4db6-a2a7-061f4b74dbd8'); -- Rat
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', '7c71b9f5-44cb-4b62-8ff1-bc4c39c83c0a'); -- Kabouter
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', '49e5d5b0-1f0d-4d80-a912-d7ecb8cbca8e'); -- Boek
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', 'c6e477f4-f11e-43d3-b34c-4de7c76b7806'); -- Ketting
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', '9b0692e1-477d-46f2-a44d-3a9b4b7b1d7d'); -- Vogel
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', '4685b2d3-4a8a-4d2c-9f78-1e5a77b4fcf6'); -- Koe
INSERT INTO game_cards (game_id, card_id) VALUES ('f7c9b2f6-6b5f-11ec-90d6-0242ac120003', '3d98a4f1-4c62-4d58-94f7-cf85acb1345c'); -- Kip


-- Invoegen van 20 CORNER tegels
INSERT INTO tiles (id, path, is_wall_left, is_wall_l_right, is_wall_l_top, is_wall_l_bottom, position_x, position_y, treasure_id)
VALUES ('3f2e8f48-3b77-4394-8f4f-8b09b6f23fd5', 'CORNER', true, false, true, false, 0, 0, NULL),
       ('7d2519f2-b6a8-4d68-970b-d596b6e8e9eb', 'CORNER', true, false, false, true, 0, 7, NULL),
       ('de3b1bcb-b7f8-4dce-bc0b-579de65912f0', 'CORNER', false, true, true, false, 7, 0, NULL),
       ('a3d3e1f4-8813-4b8d-86c4-6e5fa4b0c3b1', 'CORNER', false, true, false, true, 7, 7, NULL),
       ('b5b6e7a0-4992-4c9a-b24f-f8c6d064e4f0', 'CORNER', true, false, true, false, -1, -1, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120015'),
       ('cefb9b71-2a2e-40d7-83da-905ef8d6477d', 'CORNER', true, false, true, false, -1, -1, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120016'),
       ('a7b4a9cb-91e6-4d16-91d6-7a5d5575adf4', 'CORNER', true, false, true, false, -1, -1, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120017'),
       ('5cb9ad2c-4c1e-4c8d-b9ff-c8cbf4ad8a5b', 'CORNER', true, false, true, false, -1, -1, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120018'),
       ('ce258f56-e1c2-4f7a-9f99-8d23fa63ae5e', 'CORNER', true, false, true, false, -1, -1, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120019'),
       ('31e64390-1d92-4d61-871d-2867a2c0972e', 'CORNER', true, false, true, false, -1, -1, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120020'),
       ('4f0ab6d5-2797-45e0-92d0-9fc18e1b1cfc', 'CORNER', true, false, true, false, -1, -1, NULL),
       ('e84df0b4-6c73-4b1d-9f76-cd83c45353cf', 'CORNER', true, false, true, false, -1, -1, NULL),
       ('6d9f86bb-4a8d-4e93-b6e7-593e563a54fc', 'CORNER', true, false, true, false, -1, -1, NULL),
       ('b2b6454a-7b04-4d59-a3c4-5a5b4096d7a4', 'CORNER', true, false, true, false, -1, -1, NULL),
       ('8e3fc823-00e3-4031-8a06-7f21db417f5f', 'CORNER', true, false, true, false, -1, -1, NULL),
       ('db1d2ebc-2b65-4643-8a1a-d7480c6a8c6e', 'CORNER', true, false, true, false, -1, -1, NULL),
       ('5ed2e835-708a-411b-8d94-85f19fa3fd2d', 'CORNER', true, false, true, false, -1, -1, NULL),
       ('74e58c0d-65e7-4b6b-bef6-9bff6aeb7ac8', 'CORNER', true, false, true, false, -1, -1, NULL),
       ('394d5e2f-4d02-4d41-92ef-9b24660b88e0', 'CORNER', true, false, true, false, -1, -1, NULL),
       ('cead7b46-89f4-4cb8-83c5-89b10ae1c25d', 'CORNER', true, false, true, false, -1, -1, NULL),
       ('32a0c620-4f60-4b36-9f88-15b5c66b2db8', 'CORNER', true, false, true, false, -1, -1, NULL),
       ('5fb9c720-84f4-4f9e-b6a2-b5bff8f4c5e8', 'CORNER', true, false, true, false, -1, -1, NULL),
       ('b42d9ff2-02e8-4f54-9084-e99ef18e1e8b', 'CORNER', true, false, true, false, -1, -1, NULL),
       ('64d64ae2-1fd4-48f5-9cfd-9a2fa6ddbbcf', 'CORNER', true, false, true, false, -1, -1, NULL);

-- Invoegen van 12 STRAIGHT tegels
INSERT INTO tiles (id, path, is_wall_left, is_wall_l_right, is_wall_l_top, is_wall_l_bottom, position_x, position_y, treasure_id)
VALUES
    ('09cf3a3e-b79e-439d-8481-760dbfc2c3a8', 'STRAIGHT', false, false, true, true, -1, -1, NULL),
    ('a79860b7-1d05-44b7-8b24-469ac3e26062', 'STRAIGHT', false, false, true, true, -1, -1, NULL),
    ('2c236d9c-fd1e-4b30-8d3d-66064d4d87d6', 'STRAIGHT', false, false, true, true, -1, -1, NULL),
    ('edc1c3c1-f683-4e68-863c-48b5b29bb569', 'STRAIGHT', false, false, true, true, -1, -1, NULL),
    ('d4d7a924-e9e8-4c72-9119-5d438c02e3a8', 'STRAIGHT', false, false, true, true, -1, -1, NULL),
    ('b06959b0-36c2-4de7-85c4-845a3dcb075a', 'STRAIGHT', false, false, true, true, -1, -1, NULL),
    ('6c0a53a0-bd5d-4c5d-94e8-559e4684a94a', 'STRAIGHT', false, false, true, true, -1, -1, NULL),
    ('48c8de54-2a4b-4f38-8518-70d5e52d7f9b', 'STRAIGHT', false, false, true, true, -1, -1, NULL),
    ('e739e720-94e4-4b44-875d-3a00cb0a0713', 'STRAIGHT', false, false, true, true, -1, -1, NULL),
    ('25e4a4c6-e03f-4fc7-b823-f92f7a11b4e4', 'STRAIGHT', false, false, true, true, -1, -1, NULL),
    ('a4a73b41-bb14-4b2e-9f37-44b6a34f405e', 'STRAIGHT', false, false, true, true, -1, -1, NULL),
    ('2b91b059-2f9d-43e4-9b39-2623d9a007d6', 'STRAIGHT', false, false, true, true, -1, -1, NULL);

-- Invoegen van 18 CROSSPOINT tegels
INSERT INTO tiles (id, path, is_wall_left, is_wall_l_right, is_wall_l_top, is_wall_l_bottom, position_x, position_y, treasure_id)
VALUES
    ('e61b61ef-6a44-4a94-bb52-97f60e3c5677', 'CROSSPOINT', false, false, true, false, 2, 0, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120003'),
    ('0c823ec2-bc91-4e26-84b8-bb063e9692f7', 'CROSSPOINT', false, false, true, false, 4, 0, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120004'),
    ('f3cf5934-caf0-4b34-8f23-f3c6dffb97d0', 'CROSSPOINT', true, false, false, false, 0, 2, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120005'),
    ('c1fa7d7a-94b5-4f6f-bb6e-51e16e15d415', 'CROSSPOINT', true, false, false, false, 2, 2, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120006'),
    ('8caa8052-6599-4a35-8fc6-805556f56d0e', 'CROSSPOINT', false, false, true, false, 4, 2, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120007'),
    ('31783322-e0fa-44b0-9cf7-e5a12a6a7a93', 'CROSSPOINT', false, true, false, false, 6, 2, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120008'),
    ('96d69f87-b9c8-4af1-946f-f2d06f6581e7', 'CROSSPOINT', true, false, false, false, 2, 4, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120009'),
    ('f4e4d04e-fb0e-4519-8377-b6216a30d548', 'CROSSPOINT', false, false, true, false, 4, 4, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120010'),
    ('99d33f53-2f41-418d-bd6a-2ea6f6b9ea9a', 'CROSSPOINT', false, true, false, false, 6, 4, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120011'),
    ('0b2374a3-72b2-4b92-bd60-2d912d3fa1d1', 'CROSSPOINT', false, false, false, true, 2, 6, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120012'),
    ('6fc1e4d2-1786-485b-bcf0-36a8f17ae6d7', 'CROSSPOINT', false, false, false, true, 4, 6, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120013'),
    ('c6343482-dc4e-46f5-aaa8-d01534c25a0f', 'CROSSPOINT', true, false, false, false, 0, 4, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120014'),
    ('cc3967f4-d8b8-42dc-b78d-c1a91fc0ff5e', 'CROSSPOINT', true, false, true, true, -1, -1, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120021'),
    ('bfc379f6-cf8f-4580-b2c5-56008418e93f', 'CROSSPOINT', true, false, true, true, -1, -1, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120022'),
    ('5855df69-3dc6-4ea1-8a76-4d6c4fcb0879', 'CROSSPOINT', true, false, true, true, -1, -1, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120023'),
    ('ef28e0ab-b11f-4fc0-91e1-f68243774a1d', 'CROSSPOINT', true, false, true, true, -1, -1, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120024'),
    ('b8d5692e-6e83-42e7-a6ff-8ed8e57ab015', 'CROSSPOINT', true, false, true, true, -1, -1, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120025'),
    ('a34e0026-6b0e-43c4-999c-1e1d7466c2eb', 'CROSSPOINT', true, false, true, true, -1, -1, 'd5a7b8b0-6b5f-11ec-90d6-0242ac120026');



-- Insert into Player
INSERT INTO players (id, name, is_logged_in, position_x, position_y, game_id, tile_id, current_objective_id)
VALUES ('e6e1c1b8-6b5f-11ec-90d6-0242ac120003', 'Player 1', TRUE, -1, -1, NULL,
        NULL, NULL);
INSERT INTO players (id, name, is_logged_in, position_x, position_y, game_id, tile_id, current_objective_id)
VALUES ('f8f9a0b1-6b5f-11ec-90d6-0242ac120004', 'Player 2', TRUE, -1, -1, NULL,
        NULL, NULL);

