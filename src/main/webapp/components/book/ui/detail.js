import React from "react";

import { withStyles } from '@material-ui/core/styles';
import ExpansionPanel from '@material-ui/core/ExpansionPanel';
import ExpansionPanelDetails from '@material-ui/core/ExpansionPanelDetails';
import ExpansionPanelSummary from '@material-ui/core/ExpansionPanelSummary';
import Typography from '@material-ui/core/Typography';
import ExpandMoreIcon from '@material-ui/icons/ExpandMore';
import moment from 'moment'

const useStyles = theme => ({
	root: {
		width: '100%',
	},
	heading: {
		fontSize: theme.typography.pxToRem(15),
	},
	secondaryHeading: {
		fontSize: theme.typography.pxToRem(15),
		color: theme.palette.text.secondary,
	},
	icon: {
		verticalAlign: 'bottom',
		height: 20,
		width: 20,
	},
	details: {
		alignItems: 'center',
	},
	column: {
		flexBasis: '33.33%',
	},
	sideColumn: {
		flexBasis: '66.66%',
	}
});

class Detail extends React.Component {

	render() {
		const {
			book = {},
			classes
		} = this.props;

		const {
            title = '',
            isbn = '',
			thumbnail,
			contents,
			authors,
			publisher,
			publicationDate,
			price,
			salePrice
        } = book;

		return (
			<div className={classes.root}>
				<ExpansionPanel defaultExpanded>
					<ExpansionPanelSummary
						expandIcon={<ExpandMoreIcon />}
						aria-controls="panel1c-content"
						id="panel1c-header"
					>
						<div className={classes.column}>
							<img className={classes.media} src={thumbnail}/>

						</div>
						<div className={classes.sideColumn}>
							<Typography className={classes.heading}>{title}</Typography>
							<Typography className={classes.secondaryHeading}>
								{authors} | 정가: {price}원 | 판매가: {salePrice}원 | {publisher}
							</Typography>
							<Typography className={classes.secondaryHeading}>
								출판일: {moment(publicationDate).format('YYYY년 MM월 DD일')}
							</Typography>
							<br />
							<Typography className={classes.secondaryHeading}>{contents}</Typography>
						</div>
					</ExpansionPanelSummary>
					<ExpansionPanelDetails className={classes.details}>
						<div className={classes.column} />
						<div className={classes.sideColumn}>
							<Typography variant="caption">
								ISBN: {isbn}
							</Typography>
						</div>
					</ExpansionPanelDetails>
				</ExpansionPanel>
			</div>
		);
	}
}

export default withStyles(useStyles)(Detail);

