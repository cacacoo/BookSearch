import React from "react";
import { withStyles } from '@material-ui/core/styles';
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemText from "@material-ui/core/ListItemText";
import {Typography} from "@material-ui/core";

const useStyles = () => ({
    root: {
        width: '100%',
    }
});

class HotKeywordList extends React.Component {

    renderRows() {
        const {
            hotKeywordResult = [],
        } = this.props;

        let index = 0;
        return hotKeywordResult.map((keywordCount) => {
            index = index+1;
            const {
                keyword,
                searchCount
            } = keywordCount;

            return (
                <ListItem button key={"itemkey-"+index}>
                    <ListItemText primary={keyword} />
                    <ListItemText secondary={searchCount} />
                </ListItem>
            );
        });
    }

    render() {
        const { classes } = this.props;

        return (
            <div className={classes.root}>
                <Typography>실시간 검색어 TOP10</Typography>
                <List component="nav" aria-label="hot topic keyword">
                    {this.renderRows()}
                </List>
            </div>
        );
    }
}

export default withStyles(useStyles)(HotKeywordList);




