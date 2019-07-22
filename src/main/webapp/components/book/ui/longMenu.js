import React from 'react';
import IconButton from '@material-ui/core/IconButton';
import Menu from '@material-ui/core/Menu';
import MenuItem from '@material-ui/core/MenuItem';
import MenuIcon from '@material-ui/icons/Menu';

const ITEM_HEIGHT = 48;

export default function LongMenu(props) {
    const [anchorEl, setAnchorEl] = React.useState(null);
    const open = Boolean(anchorEl);

    function handleClick(event) {
        setAnchorEl(event.currentTarget);
    }

    function handleMenuOptionClick(event) {
        props.handleMenuClick(event.target.textContent);
        setAnchorEl(null);
    }

    function handleClose() {
        setAnchorEl(null);
    }

    const options = props.options;
    return (
        <div>
            <IconButton
                edge="start"
                aria-label="More"
                aria-controls="long-menu"
                aria-haspopup="true"
                color="inherit"
                onClick={handleClick}
            >
                <MenuIcon />
            </IconButton>
            <Menu
                id="long-menu"
                anchorEl={anchorEl}
                keepMounted
                open={open}
                onClose={handleClose}
                PaperProps={{
                    style: {
                        maxHeight: ITEM_HEIGHT * 4.5,
                        width: 200,
                    },
                }}
            >
                {options.map(option => (
                    <MenuItem
                        key={option}
                        // selected={option === 'Book Search'}
                        onClick={event => handleMenuOptionClick(event)}>
                        {option}
                    </MenuItem>
                ))}
            </Menu>
        </div>
    );
}