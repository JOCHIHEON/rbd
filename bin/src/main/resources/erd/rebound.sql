SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS qnacoment;
DROP TABLE IF EXISTS admin_info;
DROP TABLE IF EXISTS fan_comment;
DROP TABLE IF EXISTS fan_board;
DROP TABLE IF EXISTS free_coment;
DROP TABLE IF EXISTS free_board;
DROP TABLE IF EXISTS macth_info;
DROP TABLE IF EXISTS player_record;
DROP TABLE IF EXISTS player_info;
DROP TABLE IF EXISTS qnaboard;
DROP TABLE IF EXISTS team_detailrecord;
DROP TABLE IF EXISTS team_info;
DROP TABLE IF EXISTS user_info;




/* Create Tables */

-- 관리자 정보
CREATE TABLE admin_info
(
	ad_no tinyint unsigned NOT NULL AUTO_INCREMENT COMMENT '관리자 번호',
	ad_id varchar(30) NOT NULL COMMENT '관리자 아이디',
	ad_name varchar(30) NOT NULL COMMENT '관리자 이름',
	ad_pwd varchar(50) NOT NULL COMMENT '관리자 비밀번호',
	ad_nick varchar(30) NOT NULL COMMENT '관리자 닉네임',
	ad_email varchar(100) NOT NULL COMMENT '관리자 이메일',
	ad_tell varchar(30) NOT NULL COMMENT '관리자 휴대폰 번호',
	ad_active tinyint DEFAULT 1 COMMENT '관리자 활성화',
	PRIMARY KEY (ad_no),
	UNIQUE (ad_id)
) COMMENT = '관리자 정보';


-- 팬 게시판
CREATE TABLE fan_board
(
	fan_no int unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '팬게번호',
	fan_title varchar(255) NOT NULL COMMENT '글제목',
	fan_content text NOT NULL COMMENT '내용',
	fan_credat datetime NOT NULL COMMENT '등록일',
	fan_moddat datetime NOT NULL COMMENT '수정일',
	fan_lookupcnt int unsigned DEFAULT 0 COMMENT '조회수',
	fan_like int unsigned DEFAULT 0 COMMENT '추천',
	fan_unlike int unsigned DEFAULT 0 COMMENT '비추천',
	ui_no int unsigned NOT NULL COMMENT '회원 번호',
	PRIMARY KEY (fan_no)
) COMMENT = '팬 게시판';


-- 팬게시판댓글
CREATE TABLE fan_comment
(
	fanco_no int unsigned NOT NULL AUTO_INCREMENT COMMENT '팬게댓글번호',
	fanco_content varchar(300) COMMENT '댓글내용',
	fanco_like int unsigned DEFAULT 0 COMMENT '추천',
	fanco_unlike int unsigned DEFAULT 0 COMMENT '비추천',
	fanco_credat datetime NOT NULL COMMENT '등록일',
	fanco_moddat datetime NOT NULL COMMENT '수정일',
	ui_no int unsigned NOT NULL COMMENT '회원 번호',
	fan_no int unsigned zerofill NOT NULL COMMENT '팬게번호',
	PRIMARY KEY (fanco_no)
) COMMENT = '팬게시판댓글';


-- 자유게시판
CREATE TABLE free_board
(
	fre_no int unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '자게번호',
	fre_title varchar(255) NOT NULL COMMENT '글제목',
	fre_content text NOT NULL COMMENT '내용',
	fre_credat datetime NOT NULL COMMENT '등록일',
	fre_moddat datetime NOT NULL COMMENT '수정일',
	fre_lookupcnt int unsigned DEFAULT 0 COMMENT '조회수',
	fre_like int unsigned DEFAULT 0 COMMENT '추천',
	fre_unlike int unsigned DEFAULT 0 COMMENT '비추천',
	ui_no int unsigned NOT NULL COMMENT '회원 번호',
	PRIMARY KEY (fre_no)
) COMMENT = '자유게시판';


-- 자유게시판댓글
CREATE TABLE free_coment
(
	freco_no int unsigned NOT NULL AUTO_INCREMENT COMMENT '댓글 번호',
	freco_content varchar(300) NOT NULL COMMENT '댓글내용',
	freco_like int unsigned DEFAULT 0 COMMENT '추천',
	freco_unlike int unsigned DEFAULT 0 COMMENT '비추천',
	freco_credat datetime NOT NULL COMMENT '등록일',
	freco_moddat datetime NOT NULL COMMENT '수정일',
	fre_no int unsigned zerofill NOT NULL COMMENT '자게번호',
	ui_no int unsigned NOT NULL COMMENT '회원 번호',
	PRIMARY KEY (freco_no)
) COMMENT = '자유게시판댓글';


-- 경기일정
CREATE TABLE macth_info
(
	match_no int unsigned NOT NULL AUTO_INCREMENT COMMENT '매치 번호',
	-- 경기날짜
	match_day datetime NOT NULL COMMENT '날짜 : 경기날짜',
	-- 홈팀
	match_home tinyint unsigned COMMENT '홈 : 홈팀',
	-- 어웨이팀
	-- 
	match_away tinyint unsigned COMMENT '원정 : 어웨이팀
',
	match_hscore tinyint unsigned COMMENT '홈팀점수',
	match_ascore tinyint unsigned COMMENT '원정팀점수',
	match_time time NOT NULL COMMENT '시간',
	match_stadium varchar(30) NOT NULL COMMENT '구장',
	PRIMARY KEY (match_no),
	UNIQUE (match_stadium),
	UNIQUE (match_home, match_away)
) COMMENT = '경기일정';


-- 선수정보
CREATE TABLE player_info
(
	player_no int unsigned NOT NULL AUTO_INCREMENT COMMENT '선수번호',
	team_code tinyint unsigned NOT NULL COMMENT '팀 번호',
	player_name varchar(30) NOT NULL COMMENT '선수이름',
	player_birth varchar(50) NOT NULL COMMENT '생년월일',
	player_height double unsigned NOT NULL COMMENT '신장',
	player_position varchar(20) NOT NULL COMMENT '포지션',
	player_lookupcnt int unsigned DEFAULT 0 COMMENT '선수조회수',
	player_background varchar(100) NOT NULL COMMENT '출신고교',
	player_number tinyint unsigned NOT NULL COMMENT '번호',
	PRIMARY KEY (player_no),
	UNIQUE (player_name)
) COMMENT = '선수정보';


-- 선수기록
CREATE TABLE player_record
(
	player_no int unsigned NOT NULL AUTO_INCREMENT COMMENT '선수번호',
	team_code tinyint unsigned NOT NULL COMMENT '팀 번호',
	player_min time COMMENT '출장시간',
	player_pts double unsigned DEFAULT 0 COMMENT '득점',
	player_ast double unsigned DEFAULT 0 COMMENT '어시스트',
	player_reb double unsigned DEFAULT 0 COMMENT '리바운드',
	player_stl double unsigned DEFAULT 0 COMMENT '스틸',
	player_blk double unsigned DEFAULT 0 COMMENT '블록',
	player_fg double unsigned DEFAULT 0 COMMENT '야투',
	player_ft double unsigned DEFAULT 0 COMMENT '자유투',
	player_threept double unsigned DEFAULT 0 COMMENT '3점',
	player_fgp double unsigned DEFAULT 0 COMMENT '야투 성공률',
	player_ftp double unsigned DEFAULT 0 COMMENT '자유투 성공률',
	player_threeptp double unsigned DEFAULT 0 COMMENT '3점 성공률',
	player_to double unsigned DEFAULT 0 COMMENT '턴오버',
	PRIMARY KEY (player_no)
) COMMENT = '선수기록';


-- 문의
CREATE TABLE qnaboard
(
	qna_no int unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '문의 번호',
	qna_content text NOT NULL COMMENT '문의 내용',
	qna_credat datetime NOT NULL COMMENT '문의 등록일',
	qna_moddate datetime NOT NULL COMMENT '문의 수정일',
	ui_no int unsigned NOT NULL COMMENT '회원 번호',
	PRIMARY KEY (qna_no)
) COMMENT = '문의';


-- 답변
CREATE TABLE qnacoment
(
	qnaco_no int unsigned NOT NULL AUTO_INCREMENT COMMENT '답변 번호',
	qnaco_content text NOT NULL COMMENT '답변 내용',
	qnaco_credat datetime NOT NULL COMMENT '답변 등록일',
	qnaco_moddate datetime NOT NULL COMMENT '답변 수정일',
	ui_no int unsigned NOT NULL COMMENT '회원 번호',
	ad_no tinyint unsigned NOT NULL COMMENT '관리자 번호',
	qna_no int unsigned zerofill NOT NULL COMMENT '문의 번호',
	PRIMARY KEY (qnaco_no)
) COMMENT = '답변';


-- 팀 상세기록
CREATE TABLE team_detailrecord
(
	team_code tinyint unsigned NOT NULL COMMENT '팀 번호',
	teamde_pts double unsigned COMMENT '팀 득점',
	teamde_lostpts double unsigned COMMENT '팀 실점',
	teamde_assist double unsigned COMMENT '팀 어시스트',
	teamde_reb double unsigned COMMENT '팀 리바운드',
	teamde_stl double unsigned COMMENT '팀 스틸',
	teamde_blk double unsigned COMMENT '팀 블록',
	teamde_fg double unsigned COMMENT '팀 야투',
	teamde_threept double unsigned COMMENT '팀 3점',
	teamde_ft double unsigned COMMENT '팀 자유투',
	teamde_fgp double unsigned COMMENT '팀 야투 성공률',
	teamde_threeptp double unsigned COMMENT '팀 3점 성공률',
	teamde_ftp double unsigned COMMENT '팀 자유투 성공률',
	teamde_to double unsigned COMMENT '팀 턴오버',
	PRIMARY KEY (team_code),
	UNIQUE (team_code)
) COMMENT = '팀 상세기록';


-- 팀 정보
CREATE TABLE team_info
(
	team_code tinyint unsigned NOT NULL COMMENT '팀 번호',
	team_name varchar(50) NOT NULL COMMENT '팀명',
	team_owner varchar(30) NOT NULL COMMENT '구단주',
	team_leader varchar(30) NOT NULL COMMENT '단장',
	team_director varchar(30) NOT NULL COMMENT '감독',
	team_coach varchar(30) NOT NULL COMMENT '코치',
	team_address varchar(255) NOT NULL COMMENT '주소',
	team_company varchar(255) NOT NULL COMMENT '연고지/모기업',
	PRIMARY KEY (team_code),
	UNIQUE (team_code),
	UNIQUE (team_name)
) COMMENT = '팀 정보';


-- 회원 정보
CREATE TABLE user_info
(
	ui_no int unsigned NOT NULL AUTO_INCREMENT COMMENT '회원 번호',
	ui_id varchar(30) NOT NULL COMMENT '회원 아이디',
	ui_name varchar(30) NOT NULL COMMENT '회원 이름',
	ui_pwd varchar(50) NOT NULL COMMENT '회원 비밀번호',
	ui_nick varchar(30) NOT NULL COMMENT '회원 닉네임',
	ui_support tinyint(10) unsigned NOT NULL COMMENT '회원 서포트팀',
	ui_email varchar(100) NOT NULL COMMENT '회원이메일',
	ui_tell varchar(30) NOT NULL COMMENT '회원 휴대폰 번호',
	ui_active tinyint DEFAULT 1 COMMENT '회원 활성화',
	PRIMARY KEY (ui_no),
	UNIQUE (ui_id)
) COMMENT = '회원 정보';



/* Create Foreign Keys */

ALTER TABLE qnacoment
	ADD FOREIGN KEY (ad_no)
	REFERENCES admin_info (ad_no)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE fan_comment
	ADD FOREIGN KEY (fan_no)
	REFERENCES fan_board (fan_no)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE free_coment
	ADD FOREIGN KEY (fre_no)
	REFERENCES free_board (fre_no)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE player_record
	ADD FOREIGN KEY (player_no)
	REFERENCES player_info (player_no)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE qnacoment
	ADD FOREIGN KEY (qna_no)
	REFERENCES qnaboard (qna_no)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE macth_info
	ADD FOREIGN KEY (match_away)
	REFERENCES team_info (team_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE macth_info
	ADD FOREIGN KEY (match_home)
	REFERENCES team_info (team_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE player_info
	ADD FOREIGN KEY (team_code)
	REFERENCES team_info (team_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE player_record
	ADD FOREIGN KEY (team_code)
	REFERENCES team_info (team_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE team_detailrecord
	ADD FOREIGN KEY (team_code)
	REFERENCES team_info (team_code)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE fan_board
	ADD FOREIGN KEY (ui_no)
	REFERENCES user_info (ui_no)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE fan_comment
	ADD FOREIGN KEY (ui_no)
	REFERENCES user_info (ui_no)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE free_board
	ADD FOREIGN KEY (ui_no)
	REFERENCES user_info (ui_no)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE free_coment
	ADD FOREIGN KEY (ui_no)
	REFERENCES user_info (ui_no)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE qnaboard
	ADD FOREIGN KEY (ui_no)
	REFERENCES user_info (ui_no)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE qnacoment
	ADD FOREIGN KEY (ui_no)
	REFERENCES user_info (ui_no)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



