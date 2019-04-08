import React, {Component} from 'react';
import PropTypes from "prop-types";


export default class Button extends Component {

  static propTypes = {
    onClick: PropTypes.func
  };

  onClick = (elem) => {
    if(typeof this.props.onClick === "function" ) {
      this.props.onClick(elem);
    }
  };

  render() {
    return (
        <button onClick={this.onClick}>{this.props.children}</button>
    );
  }
}

