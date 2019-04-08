import React, {Component} from 'react';
import PropTypes from "prop-types";


export default class NewItem extends Component {

  static propTypes = {
    onAdd: PropTypes.func
  };

  onEnter = (elem) => {
    let event = elem || window.event;
    if(typeof this.props.onAdd === "function" ) {
      if(event.keyCode === 13) {
        this.props.onAdd(elem.target.value);
        elem.target.value = "";
      }
    }
  };

  render() {
    return (
      <div className="new-item">
        <input type="text" name="text" onKeyDown={this.onEnter} />
      </div>
    );
  }
}

