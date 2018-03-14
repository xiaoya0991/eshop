DELETE FROM membership_member_point_detail;

INSERT INTO membership_member_point_detail(
	user_account_id,
	old_member_point,
	updated_member_point,
	new_member_point,
	update_reason,
	gmt_create,
	gmt_modified
) VALUES(
	1,
	1000,
	200,
	1200,
	'支付了一个总金额为2000元的订单',
	'2018-01-01 10:00:00',
	'2018-01-01 10:00:00'
),(
	1,
	1200,
	100,
	1300,
	'支付了一个总金额为1000元的订单',
	'2018-01-01 11:00:00',
	'2018-01-01 11:00:00'
)