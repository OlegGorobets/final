INSERT INTO public.roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO public.roles (id, name) VALUES (2, 'ROLE_USER');

INSERT INTO public.users (id, email, first_name, last_name, password) VALUES ('1be27de7-a3da-4d10-a638-5aa6cd10564d', 'admin@admin.com', 'Oleg', 'Gorobets', '$2a$10$ehr7ZHFi9uLMnj0Br3UJneeQaVw1Tsz6.xblRoMpPg9M7o8.SXG4i');
INSERT INTO public.users (id, email, first_name, last_name, password) VALUES ('c5acc020-7b56-4d23-92ee-cd56e324d57b', 'user@user.com', 'Oleg', 'Gorobets', '$2a$10$0k7KnkPGpEcJZjdMOavlYeEYoZVAPehrwgDAXL7p33Y8w3uOQDkUi');
INSERT INTO public.users (id, email, first_name, last_name, password) VALUES ('14a8d23c-52ff-4bf4-8ff6-f782cfccbee8', 'nixuchihapotter@gmail.com', 'Олег', 'Горобець', null);
INSERT INTO public.users (id, email, first_name, last_name, password) VALUES ('a0c64e48-dc8b-4bf5-8983-2273c93a85e7', 'sofiahardy7@gmail.com', 'Sofia', 'Hardy', null);

INSERT INTO public.user_role (user_id, role_id) VALUES ('1be27de7-a3da-4d10-a638-5aa6cd10564d', 1);
INSERT INTO public.user_role (user_id, role_id) VALUES ('c5acc020-7b56-4d23-92ee-cd56e324d57b', 2);
INSERT INTO public.user_role (user_id, role_id) VALUES ('14a8d23c-52ff-4bf4-8ff6-f782cfccbee8', 2);
INSERT INTO public.user_role (user_id, role_id) VALUES ('a0c64e48-dc8b-4bf5-8983-2273c93a85e7', 2);

INSERT INTO public.category (category_id, name) VALUES ('6713d9f5-f1f0-4e09-8f4f-d0127d12c6e9', 'Category1');
INSERT INTO public.category (category_id, name) VALUES ('6c81ac97-b844-451c-a5c2-00d422aaec74', 'Category2');
INSERT INTO public.category (category_id, name) VALUES ('b71e2d74-c1ce-4cb1-98a1-8c5411b5d019', 'Category3');
INSERT INTO public.category (category_id, name) VALUES ('eb17d2d1-d3f9-45c3-b28e-7037550a285e', 'Category4');
INSERT INTO public.category (category_id, name) VALUES ('a2ca5d69-6aa9-4ec8-b1e3-53e4b8d13b49', 'Category5');
INSERT INTO public.category (category_id, name) VALUES ('baa6d4ed-7162-4d09-94df-70e1a9d6a024', 'Category6');
INSERT INTO public.category (category_id, name) VALUES ('d5b08873-f310-46da-a27a-76325955fa3c', 'Category7');
INSERT INTO public.category (category_id, name) VALUES ('d565630a-e0bf-48db-a6f5-16d2829da965', 'Category8');
INSERT INTO public.category (category_id, name) VALUES ('7e6a7978-d438-443f-b08d-6cf3fc2ac00b', 'Category9');
INSERT INTO public.category (category_id, name) VALUES ('32f4a197-3002-47d0-ab1a-0507d63ab987', 'Category10');

INSERT INTO public.product (id, description, image, name, price, category_id) VALUES ('07f26fea-7800-48dd-8026-2e4802d71735', '5', 'Black Wildflowers14695_rectangle.jpg', 'Product5', 1234.00, '6713d9f5-f1f0-4e09-8f4f-d0127d12c6e9');
INSERT INTO public.product (id, description, image, name, price, category_id) VALUES ('42085175-a254-4b78-95a9-27e78cf7a95b', '4', 'Avocado Pattern on Lime Green17765_rectangle.jpg', 'Product4', 1.50, '6713d9f5-f1f0-4e09-8f4f-d0127d12c6e9');
INSERT INTO public.product (id, description, image, name, price, category_id) VALUES ('486e7b20-2278-4a03-b5ec-04c8f2105b07', '2', 'Anemones Coral Pattern17966_rectangle.jpg', 'Product2', 2.00, '6713d9f5-f1f0-4e09-8f4f-d0127d12c6e9');
INSERT INTO public.product (id, description, image, name, price, category_id) VALUES ('80b11048-2c09-47df-aa67-22a11112e301', '1', 'Alley6225_rectangle.jpg', 'Product1', 1.00, '6713d9f5-f1f0-4e09-8f4f-d0127d12c6e9');
INSERT INTO public.product (id, description, image, name, price, category_id) VALUES ('812e92df-831b-4b08-8e9f-961b12d7503a', '3', 'Astronaut6894_rectangle.jpg', 'Product3', 3.00, '6713d9f5-f1f0-4e09-8f4f-d0127d12c6e9');