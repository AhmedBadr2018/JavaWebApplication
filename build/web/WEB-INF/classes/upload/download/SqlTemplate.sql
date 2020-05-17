/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  nemo
 * Created: May 17, 2020
 */

CREATE TABLE attachment (
    ID bigint(20) NOT NULL,
    FILE_NAME varchar(80) NOT NULL,
    FILE_DATA blob NOT NULL,
    DESCRIPTION varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE attachment ADD PRIMARY KEY (ID);
