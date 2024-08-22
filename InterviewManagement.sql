--create database InterviewManagement
--use InterviewManagement

-- UserDepartment table (UserDepartment - User is 1 - n relation)
create table UserOfferDepartment(
	department_id int primary key identity(1,1),
	department_name nvarchar(255)
)

-- UserRole table (UserRole - User is 1 - n relation)
create table UserRole(
	role_id int primary key identity(1,1),
	role_name nvarchar(255)
)

-- User table
create table [User](
	user_id int primary key identity(1,1),
	user_full_name nvarchar(255),
	user_dob date,
	user_phone_number varchar(15),
	user_address nvarchar(255),
	user_email varchar(255),
	user_gender varchar(255),
	user_note nvarchar(500),
	user_status nvarchar(255),
	user_deparment_id int references UserOfferDepartment(department_id),
	user_roles_id int references UserRole(role_id)
)

------ FINISH CREATING User ------

-- JobLevel table (JobLevel - Job is n - n relation, hence will require a mapping table)
create table JobOfferLevel(
	level_id int identity(1, 1) primary key,
	level_title varchar(50)
)

-- JobBenefit table (JobBenefit - Job is n - n relation, hence will require a mapping table)
create table JobBenefit(
	benefit_id int identity(1, 1) primary key,
	benefit_title varchar(100)
)

-- Job table
create table Job(
	job_id int primary key identity(1,1),
	job_title nvarchar(255),
	job_start_date date,
	job_end_date date,
	job_salary_range_from float,
	job_salary_range_to float,
	job_working_address nvarchar(255),
	job_description nvarchar(500),
	job_status nvarchar(255)
)

-- JobCandidateSkill table (JobCandidateSkill - Candidate is n - n relation, hence will require a mapping table)
create table JobCandidateSkill (
    skill_id INT PRIMARY KEY identity(1,1),
    skill_name VARCHAR(100)
)

-- JobSkillMapper (This table holds skills for each job)
create table JobSkillMapper(
	job_id int references Job(job_id),
	skill_id int references JobCandidateSkill(skill_id),
	primary key(job_id, skill_id)
)

-- JobBenefitMapper (This table holds benefits for each job)
create table JobBenefitMapper(
	job_id int references Job(job_id),
	benefit_id int references JobBenefit(benefit_id),
	primary key(job_id, benefit_id)
)

-- JobLevelMapper (This table holds levels for each job)
create table JobLevelMapper(
	job_id int references Job(job_id),
	level_id int references JobOfferLevel(level_id),
	primary key(job_id, level_id)
)

-- FINISH CREATING Job

-- CandidateOfferPosition table (CandidatePosition - Candidate is 1 - n relation)
create table CandidateOfferPosition (
    position_id INT PRIMARY KEY identity(1,1),
    postition_title VARCHAR(100)
)

-- Candidate table
create table Candidate(
	candidate_id INT PRIMARY KEY identity(1,1),
    candidate_fullname NVARCHAR(100),
    candidate_email VARCHAR(100),
	candidate_year_of_experience int,
    candidate_phonenumber VARCHAR(20),
    candidate_dob DATE,
    candidate_cv_attachment NVARCHAR(100),
    candidate_address VARCHAR(200),
    candidate_gender VARCHAR(20),
    candidate_note nvarchar(500),
	candidate_status nvarchar(255),
	candidate_highest_level nvarchar(255),
	candidate_position_id int references CandidateOfferPosition(position_id),
    candidate_recruiter_id int references [User](user_id),
	candidate_owner_hr_id int references [User](user_id),
)

-- CandidateSkillMapper table (This table holds skills of each candidate)
create table CandidateSkillMapper(
	candidate_id int references Candidate(candidate_id),
	skill_id int references JobCandidateSkill(skill_id),
	primary key(candidate_id, skill_id)
)

------ FINISH CREATING Candidate

-- Interview table
create table [Interview](
	interview_id int primary key identity(1,1),
	interview_schedule_title nvarchar(255),
	interview_schedule date,
	interview_schedule_from time,
	interview_schedule_to time,
	interview_location nvarchar(255),
	interview_meetingid nvarchar(255),
	interview_note nvarchar(500),
	interview_result nvarchar(255),
	interview_recruiter_id int references [User](user_id),
	interview_job_id int references Job(job_id),
	interview_candidate_id int references Candidate(candidate_id)
)

-- InterviewerMapper (This table holds interviewers for each interview)
create table InterviewMapper(
	interview_id int references Interview(interview_id),
	interviewer_id int references [User](user_id),
	primary key(interview_id, interviewer_id)
)

------ FINISH CREATING Interview

-- Offer table
create table [Offer](
	offer_id int primary key identity(1,1),
	offer_contract_period_from date,
	offer_contract_period_to date,
	offer_note nvarchar(500),
	offer_basic_salary float,
	offer_due_date date,
	offer_contract nvarchar(255),
	offer_interview_info int references Interview(interview_id),
	offer_position_id int references CandidateOfferPosition(position_id),
	offer_level_id int references JobOfferLevel(level_id),
	offer_department_id int references UserOfferDepartment(department_id),
	offer_approver_id int references [User](user_id),
	offer_candidate_id int references Candidate(candidate_id),
	offer_recruiter_id int references [User](user_id)
)

