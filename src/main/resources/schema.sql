
CREATE TABLE UserInfo(
	UserId VARCHAR(20) NOT NULL,
	UserName VARCHAR(100) NOT NULL,
	UserEmailId VARCHAR(100) NULL,
	Role VARCHAR(500) NULL,
	Supervisor VARCHAR(20) NULL,
	PRIMARY KEY (UserId)
);

CREATE TABLE AuthorizationInfo(
	UserId VARCHAR(20) NOT NULL,
	password VARCHAR(20) NOT NULL,
	lastLoginTimeStamp DATETIME DEFAULT CURRENT_TIMESTAMP(),
	PRIMARY KEY (UserId),
	FOREIGN KEY (UserId) REFERENCES UserInfo(UserId)
);

CREATE TABLE LeaveInfo(
	LeaveId BIGINT NOT NULL AUTO_INCREMENT,
	UserId VARCHAR(20) NOT NULL,
	LeaveType VARCHAR(20) NOT NULL,
	NoOfDays VARCHAR(20) NOT NULL,
	LeaveFrom DATE NOT NULL,
	LeaveTo DATE NOT NULL,
	LeaveReason varchar(255) NOT NULL,
	PRIMARY KEY (LeaveId),
	FOREIGN KEY (UserId) REFERENCES UserInfo(UserId)
);

CREATE TABLE ApprovalInfo(
    ApprovalId BIGINT NOT NULL AUTO_INCREMENT,
	UserId VARCHAR(30) NULL,
	IdTobeApproved BIGINT NOT NULL,
	ApprovalStatus VARCHAR(50) NULL,
	Comments VARCHAR(20) NOT NULL,
	ApprovedTimeStamp DATETIME DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (ApprovalId)
);



CREATE TABLE TimeCardInfo(
    TimecardId BIGINT NOT NULL AUTO_INCREMENT,
    UserId VARCHAR(20) NOT NULL,
    ProjectId BIGINT NOT NULL,
    ProjectName VARCHAR(20) NOT NULL,
    WeekEnding DATE NOT NULL,
    Comments varchar(255)  NULL,
    PRIMARY KEY (TimecardId),
    FOREIGN KEY (UserId) REFERENCES UserInfo(UserId)
);