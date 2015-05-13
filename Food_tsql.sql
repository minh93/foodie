use foodie
go

-- Table food
create table food(
"f_id" INT IDENTITY PRIMARY KEY,
"a_id" INT UNIQUE,
"ingredient" NVARCHAR(512),
"type" NVARCHAR(64)
)

-- Table location
create table location(
"l_id" INT IDENTITY PRIMARY KEY,
"a_id" INT UNIQUE,
"loc" GEOGRAPHY,
"address" NVARCHAR(100),
"city" NVARCHAR(45),
"tel" VARCHAR(20),
"open_time" DATETIME,
"close_time" DATETIME
)

-- Abstract table
create table abstract(
"a_id" INT PRIMARY KEY,
"name" NVARCHAR(45),
"type" VARCHAR(64),
"s_description" NVARCHAR(512),
"thumbnail" NVARCHAR(512),              -- Anh icon cho object
"create_by" INT 
)

-- Table vote
create table vote(
"v_id" INT IDENTITY PRIMARY KEY,
"u_id" INT,
"type" INT,
"a_id" INT,
"mark" INT
)

-- Table User Info
create table user_info(
"u_id" INT IDENTITY PRIMARY KEY,
"username" NVARCHAR (45),
"real_name" NVARCHAR (128),
"email" VARCHAR(128),
"password" NVARCHAR(64)
)

-- Table food_on_location
create table food_on_location(
"fl_id" INT IDENTITY PRIMARY KEY,
"f_id" INT,
"l_id" INT,
"price" TEXT
)

-- Table Comment
create table comment(
"c_id" INT IDENTITY PRIMARY KEY,
"u_id" INT,
"a_id" INT,
"time_stamp" FLOAT,
"content" TEXT
)

-- Table Image catalog
create table image_album(
"a_id" INT PRIMARY KEY
)

create table image(
"i_id" NVARCHAR(64) PRIMARY KEY, -- Duong dan den file anh tren server
"ia_id" INT
)

-- Ref key
alter table "food_on_location"
	add foreign key (f_id) references "food" (f_id);
alter table "food_on_location"
	add foreign key (l_id) references "location" (l_id);
alter table "vote"
	add foreign key ("u_id") references "user_info" ("u_id");
alter table "vote"
	add foreign key ("a_id") references "abstract" ("a_id");
alter table "comment"
	add foreign key ("u_id") references "user_info" ("u_id");
alter table "comment"
	add foreign key ("a_id") references "abstract" ("a_id");
	
alter table "image"
	add foreign key ("ia_id") references "image_album" ("a_id");
	
alter table "food"
	add foreign key ("a_id") references "abstract" ("a_id");
	
alter table "location"
	add foreign key ("a_id") references "abstract" ("a_id");

alter table "image_album"
	add foreign key ("a_id") references "abstract" ("a_id");

alter table "abstract"
	add foreign key ("create_by") references "user_info" ("u_id");
-- Create full text search 
create fulltext catalog abstract_description;
go
create fulltext index on abstract(
	"s_description" Language 1066)
	key index PK__abstract__566AFA9ABFEB7D70
		on abstract_description;

SELECT * 
FROM food
WHERE CONTAINS("description", 'Ngon ');

select * from sys.key_constraints