DELETE FROM membership_member_level_detail;

INSERT INTO membership_member_level_detail(
	user_account_id,
	old_growth_value,
	updated_growth_value,
	new_growth_value,
	old_member_level,
	new_member_level,
	update_reason,
	gmt_create,
	gmt_modified
) VALUES(
	1,
	1000,
	200,
	1200,
	1,
	2,
	'支付了一个总金额为2000元的订单',
	'2018-01-01 10:00:00',
	'2018-01-01 10:00:00'
),(
	1,
	1200,
	100,
	1300,
	2,
	2,
	'支付了一个总金额为1000元的订单',
	'2018-01-01 11:00:00',
	'2018-01-01 11:00:00'
)