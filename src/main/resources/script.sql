--
-- Name: tb_actor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_actor (
    id bigint NOT NULL,
    birthday date,
    nacionality character varying(255),
    name character varying(255),
    movie_id bigint
);


ALTER TABLE public.tb_actor OWNER TO postgres;

--
-- Name: tb_actor_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.tb_actor ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.tb_actor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: tb_category; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_category (
    id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.tb_category OWNER TO postgres;

--
-- Name: tb_category_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.tb_category ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.tb_category_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: tb_comment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_comment (
    id bigint NOT NULL,
    moment timestamp(6) with time zone,
    text character varying(255),
    movie_id bigint,
    user_id bigint,
    comment_id bigint
);


ALTER TABLE public.tb_comment OWNER TO postgres;

--
-- Name: tb_comment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.tb_comment ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.tb_comment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: tb_movie; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_movie (
    id bigint NOT NULL,
    description character varying(255),
    release_date date,
    review_rating double precision,
    title character varying(255),
    category_id bigint
);


ALTER TABLE public.tb_movie OWNER TO postgres;

--
-- Name: tb_movie_actor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_movie_actor (
    movie_id bigint NOT NULL,
    actor_id bigint NOT NULL
);


ALTER TABLE public.tb_movie_actor OWNER TO postgres;

--
-- Name: tb_movie_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.tb_movie ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.tb_movie_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Name: tb_user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.tb_user (
    id bigint NOT NULL,
    email character varying(255),
    name character varying(255),
    password character varying(255)
);


ALTER TABLE public.tb_user OWNER TO postgres;

--
-- Name: tb_user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

ALTER TABLE public.tb_user ALTER COLUMN id ADD GENERATED BY DEFAULT AS IDENTITY (
    SEQUENCE NAME public.tb_user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- Data for Name: tb_actor; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_actor (id, birthday, nacionality, name, movie_id) VALUES (1, '1980-11-12', 'Canadense', 'Ryan Gosling', NULL);
INSERT INTO public.tb_actor (id, birthday, nacionality, name, movie_id) VALUES (2, '1988-11-06', 'Americana', 'Emma Stone', NULL);
INSERT INTO public.tb_actor (id, birthday, nacionality, name, movie_id) VALUES (3, '1974-11-11', 'Americano', 'Leonardo DiCaprio', NULL);
INSERT INTO public.tb_actor (id, birthday, nacionality, name, movie_id) VALUES (4, '1984-11-22', 'Americana', 'Scarlett Johansson', NULL);


--
-- Data for Name: tb_category; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_category (id, name) VALUES (1, 'Terror');
INSERT INTO public.tb_category (id, name) VALUES (2, 'Ficção Científica');
INSERT INTO public.tb_category (id, name) VALUES (3, 'Drama');
INSERT INTO public.tb_category (id, name) VALUES (4, 'Ação');


--
-- Data for Name: tb_comment; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_comment (id, moment, text, movie_id, user_id, comment_id) VALUES (1, '2025-02-01 20:48:39.301921+00', 'Filme assustador, Pennywise é sinistro!', 1, 1, NULL);
INSERT INTO public.tb_comment (id, moment, text, movie_id, user_id, comment_id) VALUES (2, '2025-02-01 20:48:39.301921+00', 'Ótima história e efeitos visuais impressionantes!', 2, 2, NULL);
INSERT INTO public.tb_comment (id, moment, text, movie_id, user_id, comment_id) VALUES (3, '2025-02-01 20:48:39.301921+00', 'Sempre me emociono com esse filme.', 3, 3, NULL);


--
-- Data for Name: tb_movie; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_movie (id, description, release_date, review_rating, title, category_id) VALUES (1, 'Um grupo de crianças enfrenta um palhaço assustador.', '2017-09-08', 7.3, 'It: A Coisa', 1);
INSERT INTO public.tb_movie (id, description, release_date, review_rating, title, category_id) VALUES (2, 'Exploração espacial em busca de um novo lar para a humanidade.', '2014-11-07', 8.7, 'Interestelar', 2);
INSERT INTO public.tb_movie (id, description, release_date, review_rating, title, category_id) VALUES (3, 'Romance épico baseado em uma tragédia real.', '1997-12-19', 7.9, 'Titanic', 3);


--
-- Data for Name: tb_movie_actor; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_movie_actor (movie_id, actor_id) VALUES (1, 1);
INSERT INTO public.tb_movie_actor (movie_id, actor_id) VALUES (1, 2);
INSERT INTO public.tb_movie_actor (movie_id, actor_id) VALUES (2, 3);
INSERT INTO public.tb_movie_actor (movie_id, actor_id) VALUES (3, 3);
INSERT INTO public.tb_movie_actor (movie_id, actor_id) VALUES (3, 4);


--
-- Data for Name: tb_user; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.tb_user (id, email, name, password) VALUES (1, 'rodrigo@gmail.com', 'Rodrigo', 'senha123');
INSERT INTO public.tb_user (id, email, name, password) VALUES (2, 'ana@gmail.com', 'Ana', 'senha456');
INSERT INTO public.tb_user (id, email, name, password) VALUES (3, 'carlos@gmail.com', 'Carlos', 'senha789');


--
-- Name: tb_actor_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_actor_id_seq', 1, false);


--
-- Name: tb_category_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_category_id_seq', 4, true);


--
-- Name: tb_comment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_comment_id_seq', 1, false);


--
-- Name: tb_movie_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_movie_id_seq', 1, true);


--
-- Name: tb_user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.tb_user_id_seq', 1, false);


--
-- Name: tb_actor tb_actor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_actor
    ADD CONSTRAINT tb_actor_pkey PRIMARY KEY (id);


--
-- Name: tb_category tb_category_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_category
    ADD CONSTRAINT tb_category_pkey PRIMARY KEY (id);


--
-- Name: tb_comment tb_comment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_comment
    ADD CONSTRAINT tb_comment_pkey PRIMARY KEY (id);


--
-- Name: tb_movie_actor tb_movie_actor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_movie_actor
    ADD CONSTRAINT tb_movie_actor_pkey PRIMARY KEY (movie_id, actor_id);


--
-- Name: tb_movie tb_movie_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_movie
    ADD CONSTRAINT tb_movie_pkey PRIMARY KEY (id);


--
-- Name: tb_user tb_user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_user
    ADD CONSTRAINT tb_user_pkey PRIMARY KEY (id);


--
-- Name: tb_comment fk3kuip06uwa6ivpt6cffnhmcec; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_comment
    ADD CONSTRAINT fk3kuip06uwa6ivpt6cffnhmcec FOREIGN KEY (comment_id) REFERENCES public.tb_user(id);


--
-- Name: tb_comment fk45c1cuqlljd60ihc9j0962ekq; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_comment
    ADD CONSTRAINT fk45c1cuqlljd60ihc9j0962ekq FOREIGN KEY (user_id) REFERENCES public.tb_user(id);


--
-- Name: tb_comment fki79tsew4u3uuilsvu6363c5ve; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_comment
    ADD CONSTRAINT fki79tsew4u3uuilsvu6363c5ve FOREIGN KEY (movie_id) REFERENCES public.tb_movie(id);


--
-- Name: tb_movie_actor fkkc11oso89pvbyrwpg265bmj9v; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_movie_actor
    ADD CONSTRAINT fkkc11oso89pvbyrwpg265bmj9v FOREIGN KEY (movie_id) REFERENCES public.tb_movie(id);


--
-- Name: tb_movie_actor fknaiva749sdfsiyo4xsj3xajqi; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_movie_actor
    ADD CONSTRAINT fknaiva749sdfsiyo4xsj3xajqi FOREIGN KEY (actor_id) REFERENCES public.tb_actor(id);


--
-- Name: tb_movie fko51cku8l99lu7c9g7l9c06tho; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_movie
    ADD CONSTRAINT fko51cku8l99lu7c9g7l9c06tho FOREIGN KEY (category_id) REFERENCES public.tb_category(id);


--
-- Name: tb_actor fktg472thvyinx50macm84bij1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.tb_actor
    ADD CONSTRAINT fktg472thvyinx50macm84bij1 FOREIGN KEY (movie_id) REFERENCES public.tb_movie(id);


--
-- PostgreSQL database dump complete
--

