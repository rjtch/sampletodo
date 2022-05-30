CREATE DATABASE notification;
CREATE TABLE IF NOT EXISTS notification (
    notificationId INT NOT NULL,
    toUserId INT NOT NULL,
    sender varchar(250) NOT NULL,
    toUserName varchar(250) NOT NULL,
    message varchar(250) NOT NULL,

    PRIMARY KEY (notificationId)
    );
