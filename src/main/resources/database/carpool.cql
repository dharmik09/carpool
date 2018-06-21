CREATE KEYSPACE carpool
WITH replication = {
	'class' : 'SimpleStrategy',
	'replication_factor' : 1
};

use carpool;

CREATE TABLE carpool.users (
	id bigint,
	email text,
	password text,
	dobTime timestamp,
	gender text,
	firstName text,
	lastName text,
	clientType int,
	accessToken text,
	refereshToken text,
	socialNetworkId text,
	roleId bigint,
	mobile text,
	otp text,
	otpCreationTime timestamp,
	createdBy text,
	createdTime timestamp,
	modifiedBy text,
	modifiedTime timestamp,
	imageId text,
	persionalInfo text,
	isVarified text,
	PRIMARY KEY (id)
);

CREATE TABLE carpool.userRole
 (
	roleId bigint,
	name text,
	password text,
	createdBy text,
	createdTime timestamp,
	modifiedBy text,
	modifiedTime timestamp,
	PRIMARY KEY (roleId)
);
CREATE TABLE carpool.userPaymentDetails
 (
	userPaymentDetailId bigint,
	userId bigint,
	paymentClientType text,
	cardLast4Digits text,
	cardExpireMonth int,
	cardExpireYear int,
	createdBy text,
	createdTime timestamp,
	updatedBy text,
	modifiedTime timestamp,
	PRIMARY KEY (userPaymentDetailId)
);

create table carpool.userCars(
	userCardId bigint PRIMARY KEY,
	carMakerId bigint,
	carModelId bigint,
	colour text,
	country text,
	numberPlate text,
	imageId bigint,
	createdBy text,
	createdTime timestamp,
	modifiedBy text,
	modifiedTime timestamp,
	userId bigint
);

 create table carpool.userPreferences(
	userPreferenceId bigint PRIMARY KEY,
	userId bigint,
	preferenceType int,
	maxDetour int,
	maxLuggage  text,
	pets int,
	smoke int,
	userCarId bigint,
	bookingWhileDrive int,
	onlyFemail int,
	ratingNotification int,
	chatNotification int,
	rideNotification int,
	paymentNotification int,
	minDriverRating int,
	createdBy text,
	createdTime timestamp,
	modifiedBy text,
	modifiedTime timestamp
);

create table carpool.userPreferencesMaster(
	userPreferenceMasterId bigint PRIMARY KEY,
	preferenceName bigint ,
	preferenceId bigint,
	createdBy text,
	createdTime timestamp,
	modifiedBy text,
	modifiedTime timestamp
);
	
create table carpool.userPreferencesMasterValues(
	userPreferenceMasterId bigint PRIMARY KEY,
	preferenceValueId bigint ,
	preferenceId bigint,
	preferenceLabel text
	);
create table carpool.images(
	imageId bigint PRIMARY KEY,
	imageType bigint,
	imagePath int,
	createdBy text,
	createdTime timestamp,
	modifiedBy text,
	modifiedTime timestamp
);
create table carpool.carMakerMaster(
	carMakerId bigint PRIMARY KEY,
	makerName bigint,
	createdBy text,
	createdTime timestamp,
	modifiedBy text,
	modifiedTime timestamp
);
create table carpool.carModeMaster(
	carModelId bigint PRIMARY KEY,
	carMakerId bigint,
	modelName text,
	createdBy text,
	createdTime timestamp,
	modifiedBy text,
	modifiedTime timestamp
);


create table carpool.userLiveLocation(
	userLocationId bigint PRIMARY KEY,
	tripId int,
	carModelId int,
	latitude bigint,
	longitude bigint,
	nextEta text,
	createdBy text,
	createdTime timestamp,
	modifiedBy text,
	modifiedTime timestamp
);
create table carpool.staticContent(
	contentId bigint PRIMARY KEY ,
	title text,
	content text,
	createdBy text,
	createdTime timestamp,
	modifiedBy text,
	modifiedTime timestamp
);

create table carpool.userRating(
	ratingId bigint PRIMARY KEY,
	toUserId bigint,
	fromUserId bigint,
	comments text,
	ratings int,
	createdBy text,
	createdTime timestamp,
	modifiedBy text,
	modifiedTime timestamp
);

create table carpool.userNotification(
	notificationId bigint PRIMARY KEY,
	notificationType int,
	tripId bigint,
	notificationContent text,
	createdBy text,
	createdTime timestamp,
	modifiedBy text,
	modifiedTime timestamp
);
create table carpool.routes(
	riuteId bigint PRIMARY KEY,
	tripId int,
	routeJson text,
	routeType bigint,
	createdBy text,
	createdTime timestamp,
	modifiedby text,
	modifiedTime timestamp
);

create table carpool.tripRequest(
	tripRequestId bigint PRIMARY KEY,
	tripId bigint,
	userId bigint,
	estimatedTripDistance bigint,
	estimatedTripTime time,
	actualTripDistance bigint,
	actualTripEndTime time,
	tripRequestStatus int,
	startLocationText text,
	endLocationText text,
	startLocationLatitute bigint ,
	startLocationLongitute bigint,
	endLocationLatitite bigint,
	endLocationLongitute bigint,
	seats int,
	estimatedTripCost int ,
	actualTripCost int,
	createdBy text,
	createdTime timestamp,
	modifiedBy text,
	modifiedTime timestamp	
);

create table carpool.trip(
	tripId bigint PRIMARY KEY ,
	userId bigint,
	seats int,
	startLocationText text,
	endLocationText text,
	startLocationLatitute bigint,
	startLocationLongitute bigint,
	endLocationLatitite bigint,
	endLocationLongitute bigint,
	instantly text,
	tripStartTime timestamp,
	parentTripId bigint,
	tripStatus int,
	estimatedTripDistance bigint,
	estimatedTripTime time,
	actualTripDistance bigint,
	actualTripEndTime timestamp,
	tripEarning double,
	createdBy text,
	createdTime timestamp,
	modifiedBy text,
	modifiedTime timestamp
);
  
CREATE TABLE carpool.ids (
  idname text,
  nextid bigint,
  PRIMARY KEY (idname)
);

